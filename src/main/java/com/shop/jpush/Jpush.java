package com.shop.jpush;

import java.util.HashMap;
import java.util.Map;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class Jpush {

	private static final String MASTER_SECRET = "03e00eefebf43eb635e19c82";// JPush服务器端下发的master_key
	private static final String APP_KEY = "590a1aaf94242d27c5b13004";// JPush服务器端下发的app_key

	/**
	 * 构建推送对象：对所有平台，所有设备，内容为 alert的通知
	 * 
	 * @param alter
	 * @return
	 */
	public static PushPayload buildPushObject_all_all_alert(String alter) {
		return PushPayload.alertAll(alter);
	}

	/**
	 * 所有平台，推送目标是别名为 "alias"，通知内容为 alert
	 * 
	 * @param alias
	 * @param alert
	 * @return
	 */
	public static PushPayload buildPushObject_all_alias_alert(String alias, Object alert) {
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias))
				.setNotification(Notification.alert(alert)).build();
	}

	/**
	 * 构建推送对象：平台是 Android，目标是 tag的设备，通知内容是alert，并且标题为title。
	 * 
	 * @param tag
	 * @param alert
	 * @param title
	 * @param extras
	 * @return
	 */
	public static PushPayload buildPushObject_android_tag_alertWithTitle(String tag, String alert, String title,
			Map<String, String> extras) {
		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag(tag))
				.setNotification(Notification.android(alert, title, extras)).build();
	}

	/**
	 * 构建推送对象：平台是 iOS，推送目标是 tags(可以是一个设备也可以是多个设备)，推送内容同时包括通知与消息 - 通知信息是alert，消息内容是
	 * msgContent，角标数字为badge(应用程序左上角或者右上角的数字)，通知声音为sound，并且附加字段 from = "JPush"。 通知是
	 * APNs 推送通道的，消息是 JPush 应用内消息通道的。 APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
	 * 
	 * @param alert
	 * @param msgContent
	 * @param badge
	 * @param sound
	 * @param tags
	 * @return
	 */
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(Object alert, String msgContent,
			int badge, String sound, String... tags) {
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.tag_and(tags))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(IosNotification.newBuilder().setAlert(alert).setBadge(badge)
								.setSound(sound).addExtra("from", "JPush").build())
						.build())
				.setMessage(Message.content(msgContent))
				.setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
	}

	/**
	 * 构建推送对象：平台是 Andorid 与 iOS，推送的设备有（推送目标为tags和推送目标别名为aliases），推送内容是 - 内容为
	 * msg_content的消息，并且附加字段 from = JPush。
	 * 
	 * @param msg_content
	 * @param tags
	 * @param aliases
	 * @return
	 */
	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras(String msg_content, String[] tags,
			String[] aliases) {
		return PushPayload.newBuilder().setPlatform(Platform.android_ios())
				.setAudience(Audience.newBuilder().addAudienceTarget(AudienceTarget.tag(tags))
						.addAudienceTarget(AudienceTarget.alias(aliases)).build())
				.setMessage(Message.newBuilder().setMsgContent(msg_content).addExtra("from", "JPush").build()).build();
	}

	public static void main(String[] args) {
		String master_secret = Jpush.MASTER_SECRET;
		String app_key = Jpush.APP_KEY;
		JPushClient jpushClient = new JPushClient(master_secret, app_key, null, ClientConfig.getInstance());
		// PushPayload payload = Jpush.buildPushObject_all_all_alert("消息推送");
		// 多平台推送消息
		Object obj1 = args[0];
		PushPayload payload = Jpush.buildPushObject_all_alias_alert(args[1], obj1);
		// PushPayload
		// payload=PhicommPush.buildPushObject_android_tag_alertWithTitle("tag1", "123",
		// "123", null);

		try {
			PushResult result = jpushClient.sendPush(payload);
			System.out.println("Got result - " + result);

		} catch (APIConnectionException e) {
			// Connection error, should retry later
			System.out.print("Connection error, should retry later " + e);

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			System.out.println("根据返回的错误信息核查请求是否正确" + e);
			System.out.println("HTTP 状态信息码: " + e.getStatus());
			System.out.println("JPush返回的错误码: " + e.getErrorCode());
			System.out.println("JPush返回的错误信息: " + e.getErrorMessage());
		}
	}
}
