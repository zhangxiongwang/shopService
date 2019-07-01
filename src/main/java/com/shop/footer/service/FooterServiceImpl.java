package com.shop.footer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.footer.domain.GuessLike;
import com.shop.footer.repository.FooterRepository;
import com.shop.store.domian.Store;
import com.shop.store.repository.StoreRepository;

@Service
public class FooterServiceImpl implements FooterService {
	@Autowired
	FooterRepository footerRepository;
	@Autowired
	StoreRepository storeRepository;

	@Override
	public Map<String, Object> getGuessLike(String username) {
		List<GuessLike> footers = footerRepository.findByUsername(username);
		List<Store> stores = new ArrayList<>();
		for (GuessLike g : footers) {
			Optional<Store> store = storeRepository.findById(g.getClothesid());
			Store s = store.get();
			stores.add(s);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("data", stores);
		return map;
	}

	@Override
	public Map<String, Object> saveGuessLike(GuessLike footer) {
		// 查询用户下有几条浏览历史
		List<GuessLike> footers = footerRepository.findByUsername(footer.getUsername());
		// 先判断是否存在这条数据
		GuessLike gLike = footerRepository.findByClothesid(footer.getClothesid());
		if (gLike != null) {
			footerRepository.updateMarktime(footer.getMarktime(), footer.getClothesid());
		} else {
			// 如果浏览历史是4条则删除最久的一条
			if (footers.size() > 3) {
				footerRepository.delete(footers.get(0));
			}
			footerRepository.save(footer);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("data", "ok");
		return map;
	}
}
