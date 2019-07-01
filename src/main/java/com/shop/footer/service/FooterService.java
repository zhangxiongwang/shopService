package com.shop.footer.service;

import java.util.Map;

import com.shop.footer.domain.GuessLike;

public interface FooterService {

	Map<String, Object> getGuessLike(String username);

	Map<String, Object> saveGuessLike(GuessLike footer);

}
