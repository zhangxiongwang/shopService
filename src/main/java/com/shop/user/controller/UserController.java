package com.shop.user.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.shop.user.domian.AliyunUtil;
import com.shop.user.domian.User;
import com.shop.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	static HttpSession session;
	
//	登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(@RequestBody User user) {
		return userService.login(user);
	}
//	根据用户名获取用户信息
	@RequestMapping(value = "/getUserByUsername", method = RequestMethod.GET)
	public Map<String, Object> getUserByUsername(@RequestParam String username) {
		return userService.getUserByUsername(username);
	}
//	注册
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public Map<String, Object> regist(@RequestBody User user) {
		/*
		 * 对验证码进行验证
		 */
		logger.info(session.toString());
		String string = (String) session.getAttribute(user.getUsername());

		Map<String, Object> result = new HashMap<String, Object>();
		if (string.equals(user.getCode())) {
			session.removeAttribute(user.getUsername());
			return userService.regist(user);
		}
		result.put("data", "验证码不正确");
		return result;

	}

	/*
	 * 
	 * 调用阿里云短信平台做短信验证功能
	 * 
	 * 
	 */
	@RequestMapping(value = "sendcode", method = RequestMethod.POST)
	public static Map<String, String> sendMsg(@RequestBody String phoneNum, HttpServletRequest request)
			throws ClientException, InterruptedException {
		// 格式化返回值
		Map<String, String> str = new HashMap<>();
		session = request.getSession();
		String phoneNumber = (String) phoneNum;
		// 获取随机验证码
		String randomNum = createRandomNum(6);
		// 把验证码放入缓存中，以便于之后进行对比
		session.setAttribute(phoneNum, randomNum);
		 // 下面这些是阿里云短信的一些设置功能
		 String jsonContent = "{\"code\":\"" + randomNum + "\"}";
		 Map<String, String> paramMap = new HashMap<>();
		 paramMap.put("phoneNumber", phoneNumber);
		 paramMap.put("msgSign", "张辉的短信通知");
		 paramMap.put("templateCode", "SMS_131815091");
		 paramMap.put("jsonContent", jsonContent);
		 // 发短信
		 SendSmsResponse response = AliyunUtil.sendSms(paramMap);
		 Thread.sleep(3000L);
		
		 // 发送成功调用
		 if (response.getCode() != null && response.getCode().equals("OK")) {
		 logger.info("发送成功");
		 }
		logger.info("session:" + session.toString());
		str.put("data", "发送成功");
		return str;
	}

	/**
	 * 生成随机数
	 * 
	 * @param num
	 *            位数
	 * @return
	 */
	public static String createRandomNum(int num) {
		String randomNumStr = "";
		for (int i = 0; i < num; i++) {
			int randomNum = (int) (Math.random() * 10);
			randomNumStr += randomNum;
		}
		return randomNumStr;
	}
}
