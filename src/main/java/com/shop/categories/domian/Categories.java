package com.shop.categories.domian;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories {
	@Id
	private String id;
	private String favoritestitle;
	private String icon;
	private Long favoritesid;
	private String apptag;
	

	public String getApptag() {
		return apptag;
	}

	public void setApptag(String apptag) {
		this.apptag = apptag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFavoritestitle() {
		return favoritestitle;
	}

	public void setFavoritestitle(String favoritestitle) {
		this.favoritestitle = favoritestitle;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getFavoritesid() {
		return favoritesid;
	}

	public void setFavoritesid(Long favoritesid) {
		this.favoritesid = favoritesid;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", favoritestitle=" + favoritestitle + ", icon=" + icon + ", favoritesid="
				+ favoritesid + ", apptag=" + apptag + "]";
	}

}
