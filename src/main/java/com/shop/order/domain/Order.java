package com.shop.order.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.shop.address.domain.ShopAddress;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String clothesid;
	private String status;
	private String description;
	private String imgurl;
	private Date ordertime;
	private Long number;
	private Long price;
	private Integer addressid;
	@Transient
	private ShopAddress address;
	
	public ShopAddress getAddress() {
		return address;
	}
	public void setAddress(ShopAddress address2) {
		this.address = address2;
	}
	public Integer getAddressid() {
		return addressid;
	}
	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}
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
	public String getClothesid() {
		return clothesid;
	}
	public void setClothesid(String clothesid) {
		this.clothesid = clothesid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", username=" + username + ", clothesid=" + clothesid + ", status=" + status
				+ ", description=" + description + ", imgurl=" + imgurl + ", ordertime=" + ordertime + ", number="
				+ number + ", price=" + price + ", addressid=" + addressid + ", address=" + address + "]";
	}
	
}
