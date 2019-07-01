package com.shop.footer.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.footer.domain.GuessLike;
import com.shop.footer.service.FooterService;

@RestController
public class FooterController {
	@Autowired
	FooterService footerService;

	// 获取猜你喜欢列表
	@RequestMapping(value = "/getGuessLike", method = RequestMethod.GET)
	public Map<String, Object> getGuessLike(@RequestParam String username) {
		return footerService.getGuessLike(username);
	}

	// 保存猜你喜欢
	@RequestMapping(value = "/saveGuessLike", method = RequestMethod.POST)
	public Map<String, Object> saveGuessLike(@RequestBody GuessLike guessLike) {
		Date date = new Date();
		guessLike.setMarktime(date);
		return footerService.saveGuessLike(guessLike);
	}

}
