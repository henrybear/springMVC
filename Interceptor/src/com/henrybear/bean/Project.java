package com.henrybear.bean;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class Project implements Serializable {
	/**
	 * 1544256765295087529L
	 */
	private static final long serialVersionUID = 1544256765295087529L;
	private Integer id;
	private String sequence;
	private String name;
	private String cuscom;
	private String customer;
	private String custel;
	private String cusemail;
	private String customer1;
	private String custel1;
	private String cusemail1;
	private Double price;
	private Double rcvmoney;
	private Date signdate;
	private Date startdate;
	private Date enddate;
	private String salesmano;
	private String salesman;
	private String designmano;
	private String designman;
	private String makermano;
	private String maker;
	private String contract;
	private Double qualitycost;
	private String bak;
	private String bak1;
	private String bak2;
	private String bak3;
	private String bak4;
	private String bak5;
	private String bak6;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuscom() {
		return cuscom;
	}
	public void setCuscom(String cuscom) {
		this.cuscom = cuscom;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustel() {
		return custel;
	}
	public void setCustel(String custel) {
		this.custel = custel;
	}
	public String getCusemail() {
		return cusemail;
	}
	public void setCusemail(String cusemail) {
		this.cusemail = cusemail;
	}
	public String getCustomer1() {
		return customer1;
	}
	public void setCustomer1(String customer1) {
		this.customer1 = customer1;
	}
	public String getCustel1() {
		return custel1;
	}
	public void setCustel1(String custel1) {
		this.custel1 = custel1;
	}
	public String getCusemail1() {
		return cusemail1;
	}
	public void setCusemail1(String cusemail1) {
		this.cusemail1 = cusemail1;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRcvmoney() {
		return rcvmoney;
	}
	public void setRcvmoney(Double rcvmoney) {
		this.rcvmoney = rcvmoney;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getSalesmano() {
		return salesmano;
	}
	public void setSalesmano(String salesmano) {
		this.salesmano = salesmano;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getDesignmano() {
		return designmano;
	}
	public void setDesignmano(String designmano) {
		this.designmano = designmano;
	}
	public String getDesignman() {
		return designman;
	}
	public void setDesignman(String designman) {
		this.designman = designman;
	}
	public String getMakermano() {
		return makermano;
	}
	public void setMakermano(String makermano) {
		this.makermano = makermano;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public Double getQualitycost() {
		return qualitycost;
	}
	public void setQualitycost(Double qualitycost) {
		this.qualitycost = qualitycost;
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
	
	public String toJson() {
		return JSON.toJSONString(this);
	}
}
