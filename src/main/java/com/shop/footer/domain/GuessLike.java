package com.shop.footer.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guesslike")

public class GuessLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date marktime;
	private Integer markdown;
	private String username;
	private String clothesid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getMarktime() {
		return marktime;
	}
	public void setMarktime(Date marktime) {
		this.marktime = marktime;
	}
	public Integer getMarkdown() {
		return markdown;
	}
	public void setMarkdown(Integer markdown) {
		this.markdown = markdown;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClothesid() {
		return clothesid;
	}
	public void setClothesid(String clothesid) {
		this.clothesid = clothesid;
	}
	@Override
	public String toString() {
		return "Footer [id=" + id + ", marktime=" + marktime + ", markdown=" + markdown + ", username=" + username
				+ ", clothesid=" + clothesid + "]";
	}
	
}
