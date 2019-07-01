package com.shop.image.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;
	private String imgurl;
	private Long numiid;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumiid() {
		return numiid;
	}
	public void setNumiid(Long numiid) {
		this.numiid = numiid;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", imgurl=" + imgurl + ", numiid=" + numiid + "]";
	}
	
}
