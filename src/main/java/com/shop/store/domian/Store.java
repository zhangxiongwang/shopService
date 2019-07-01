package com.shop.store.domian;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import com.shop.image.domain.Image;
@Entity
@Table(name = "Clothes")
public class Store {
	@Id
	private String id;
	private String clickurl;
	private String itemurl;
	private String nick;
	private String picturl;
	private String provcity;
	private String reserveprice;
	private String shoptitle;
	private String title;
	private BigDecimal  zkfinalprice;
	private BigDecimal zkfinalpricewap;

	private Long favoritesid;
	private Long volume;
	private Long status;
	private Long sellerid;
	private Long numiid;
	@Transient
	private List<Image> images;  //评价信息
	
	
	
	public BigDecimal getZkfinalprice() {
		return zkfinalprice;
	}
	public void setZkfinalprice(BigDecimal zkfinalprice) {
		this.zkfinalprice = zkfinalprice;
	}
	public BigDecimal getZkfinalpricewap() {
		return zkfinalpricewap;
	}
	public void setZkfinalpricewap(BigDecimal zkfinalpricewap) {
		this.zkfinalpricewap = zkfinalpricewap;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClickurl() {
		return clickurl;
	}
	public void setClickurl(String clickurl) {
		this.clickurl = clickurl;
	}
	public String getItemurl() {
		return itemurl;
	}
	public void setItemurl(String itemurl) {
		this.itemurl = itemurl;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPicturl() {
		return picturl;
	}
	public void setPicturl(String picturl) {
		this.picturl = picturl;
	}
	public String getProvcity() {
		return provcity;
	}
	public void setProvcity(String provcity) {
		this.provcity = provcity;
	}
	
	public String getShoptitle() {
		return shoptitle;
	}
	public void setShoptitle(String shoptitle) {
		this.shoptitle = shoptitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getFavoritesid() {
		return favoritesid;
	}
	public void setFavoritesid(Long favoritesid) {
		this.favoritesid = favoritesid;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getSellerid() {
		return sellerid;
	}
	public void setSellerid(Long sellerid) {
		this.sellerid = sellerid;
	}
	public Long getNumiid() {
		return numiid;
	}
	public void setNumiid(Long numiid) {
		this.numiid = numiid;
	}
	
	public String getReserveprice() {
		return reserveprice;
	}
	public void setReserveprice(String reserveprice) {
		this.reserveprice = reserveprice;
	}
	
	@Override
	public String toString() {
		return "Store [id=" + id + ", clickurl=" + clickurl + ", itemurl=" + itemurl + ", nick=" + nick + ", picturl="
				+ picturl + ", provcity=" + provcity + ", reserveprice=" + reserveprice + ", shoptitle=" + shoptitle
				+ ", title=" + title + ", zkfinalprice=" + zkfinalprice + ", zkfinalpricewap=" + zkfinalpricewap
				+ ", favoritesid=" + favoritesid + ", volume=" + volume + ", status=" + status + ", sellerid="
				+ sellerid + ", numiid=" + numiid + "]";
	}

}