package com.shop.address.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")

public class ShopAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String nickname;
	private Long phone;
	private String address;
	private String description;
	private Boolean defult;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDefult() {
		return defult;
	}
	public void setDefult(Boolean defult) {
		this.defult = defult;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", username=" + username + ", nickname=" + nickname + ", phone=" + phone
				+ ", address=" + address + ", description=" + description + ", defult=" + defult + "]";
	}
	
}
