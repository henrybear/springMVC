package com.henrybear.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.JSON;

public class Book implements Serializable {

	/**
	 * 7352990154265609159L
	 */
	private static final long serialVersionUID = -7352990154265609159L;
	private int id;
	private String name;
	private String author;
	private String publicationdate;
	private String publication;
	private BigDecimal price;
	private String image;
	private String remark;
	private String bak;
	private String bak1;
	private String bak2;
	private String bak3;
	private String bak4;
	private String bak5;
	private String bak6;
	private String bak7;
	private String bak8;
	private String bak9;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublicationdate() {
		return publicationdate;
	}
	public void setPublicationdate(String publicationdate) {
		this.publicationdate = publicationdate;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
	public String getBak1() {
		return bak1;
	}
	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}
	public String getBak2() {
		return bak2;
	}
	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}
	public String getBak3() {
		return bak3;
	}
	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}
	public String getBak4() {
		return bak4;
	}
	public void setBak4(String bak4) {
		this.bak4 = bak4;
	}
	public String getBak5() {
		return bak5;
	}
	public void setBak5(String bak5) {
		this.bak5 = bak5;
	}
	public String getBak6() {
		return bak6;
	}
	public void setBak6(String bak6) {
		this.bak6 = bak6;
	}
	public String getBak7() {
		return bak7;
	}
	public void setBak7(String bak7) {
		this.bak7 = bak7;
	}
	public String getBak8() {
		return bak8;
	}
	public void setBak8(String bak8) {
		this.bak8 = bak8;
	}
	public String getBak9() {
		return bak9;
	}
	public void setBak9(String bak9) {
		this.bak9 = bak9;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publicationdate=" + publicationdate
				+ ", publication=" + publication + ", price=" + price + ", image=" + image + ", remark=" + remark
				+ ", bak=" + bak + ", bak1=" + bak1 + ", bak2=" + bak2 + ", bak3=" + bak3 + ", bak4=" + bak4 + ", bak5="
				+ bak5 + ", bak6=" + bak6 + ", bak7=" + bak7 + ", bak8=" + bak8 + ", bak9=" + bak9 + "]";
	}
	public String toJson() {
		return JSON.toJSONString(this);
	}
}
