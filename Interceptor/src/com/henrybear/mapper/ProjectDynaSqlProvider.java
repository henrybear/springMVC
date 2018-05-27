package com.henrybear.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.henrybear.bean.Project;

public class ProjectDynaSqlProvider {
	
	public String selectWhitParam(Project project) {
		return new SQL() {
			{
				SELECT("*");
				FROM("tb_project");
				WHERE("1=1");
				if(project.getSequence() != null && !project.getSequence().equals("")){
				WHERE(" sequence = #{sequence} ");
				}
				if(project.getName() != null && !project.getName().equals("")){
				WHERE(" name = #{name} ");
				}
				if(project.getCuscom() != null && !project.getCuscom().equals("")){
				WHERE(" cuscom = #{cuscom} ");
				}
				if(project.getCustomer() != null && !project.getCustomer().equals("")){
				WHERE(" customer = #{customer} ");
				}
				if(project.getCustel() != null && !project.getCustel().equals("")){
				WHERE(" custel = #{custel} ");
				}
				if(project.getCusemail() != null && !project.getCusemail().equals("")){
				WHERE(" cusemail = #{cusemail} ");
				}
				if(project.getCustomer1() != null && !project.getCustomer1().equals("")){
				WHERE(" customer1 = #{customer1} ");
				}
				if(project.getCustel1() != null && !project.getCustel1().equals("")){
				WHERE(" custel1 = #{custel1} ");
				}
				if(project.getCusemail1() != null && !project.getCusemail1().equals("")){
				WHERE(" cusemail1 = #{cusemail1} ");
				}
				if(project.getPrice() != null && !project.getPrice().equals("")){
				WHERE(" price = #{price} ");
				}
				if(project.getRcvmoney() != null && !project.getRcvmoney().equals("")){
				WHERE(" rcvmoney = #{rcvmoney} ");
				}
				if(project.getSigndate() != null && !project.getSigndate().equals("")){
				WHERE(" signdate = #{signdate} ");
				}
				if(project.getStartdate() != null && !project.getStartdate().equals("")){
				WHERE(" startdate = #{startdate} ");
				}
				if(project.getEnddate() != null && !project.getEnddate().equals("")){
				WHERE(" enddate = #{enddate} ");
				}
				if(project.getSalesmano() != null && !project.getSalesmano().equals("")){
				WHERE(" salesmano = #{salesmano} ");
				}
				if(project.getSalesman() != null && !project.getSalesman().equals("")){
				WHERE(" salesman = #{salesman} ");
				}
				if(project.getDesignmano() != null && !project.getDesignmano().equals("")){
				WHERE(" designmano = #{designmano} ");
				}
				if(project.getDesignman() != null && !project.getDesignman().equals("")){
				WHERE(" designman = #{designman} ");
				}
				if(project.getMakermano() != null && !project.getMakermano().equals("")){
				WHERE(" makermano = #{makermano} ");
				}
				if(project.getMaker() != null && !project.getMaker().equals("")){
				WHERE(" maker = #{maker} ");
				}
				if(project.getContract() != null && !project.getContract().equals("")){
				WHERE(" contract = #{contract} ");
				}
				if(project.getQualitycost() != null && !project.getQualitycost().equals("")){
				WHERE(" qualitycost = #{qualitycost} ");
				}
				if(project.getBak() != null && !project.getBak().equals("")){
				WHERE(" bak = #{bak} ");
				}
				if(project.getBak1() != null && !project.getBak1().equals("")){
				WHERE(" bak1 = #{bak1} ");
				}
				if(project.getBak2() != null && !project.getBak2().equals("")){
				WHERE(" bak2 = #{bak2} ");
				}
				if(project.getBak3() != null && !project.getBak3().equals("")){
				WHERE(" bak3 = #{bak3} ");
				}
				if(project.getBak4() != null && !project.getBak4().equals("")){
				WHERE(" bak4 = #{bak4} ");
				}
				if(project.getBak5() != null && !project.getBak5().equals("")){
				WHERE(" bak5 = #{bak5} ");
				}
				if(project.getBak6() != null && !project.getBak6().equals("")){
				WHERE(" bak6 = #{bak6} ");
				}

			}
		}.toString();
	}
	
	public String insertProject(Project project) {
		return new SQL() {
			{
				INSERT_INTO("tb_project");
				if (project.getId() != null) {
					VALUES("id", "#{id}");
				}
				if (project.getSequence() != null) {
					VALUES("sequence", "#{sequence}");
				}
				if (project.getName() != null) {
					VALUES("name", "#{name}");
				}
				if (project.getCuscom() != null) {
					VALUES("cuscom", "#{cuscom}");
				}
				if (project.getCustomer() != null) {
					VALUES("customer", "#{customer}");
				}
				if (project.getCustel() != null) {
					VALUES("custel", "#{custel}");
				}
				if (project.getCusemail() != null) {
					VALUES("cusemail", "#{cusemail}");
				}
				if (project.getCustomer1() != null) {
					VALUES("customer1", "#{customer1}");
				}
				if (project.getCustel1() != null) {
					VALUES("custel1", "#{custel1}");
				}
				if (project.getCusemail1() != null) {
					VALUES("cusemail1", "#{cusemail1}");
				}
				if (project.getPrice() != null) {
					VALUES("price", "#{price}");
				}
				if (project.getRcvmoney() != null) {
					VALUES("rcvmoney", "#{rcvmoney}");
				}
				if (project.getSigndate() != null) {
					VALUES("signdate", "#{signdate}");
				}
				if (project.getStartdate() != null) {
					VALUES("startdate", "#{startdate}");
				}
				if (project.getEnddate() != null) {
					VALUES("enddate", "#{enddate}");
				}
				if (project.getSalesmano() != null) {
					VALUES("salesmano", "#{salesmano}");
				}
				if (project.getSalesman() != null) {
					VALUES("salesman", "#{salesman}");
				}
				if (project.getDesignmano() != null) {
					VALUES("designmano", "#{designmano}");
				}
				if (project.getDesignman() != null) {
					VALUES("designman", "#{designman}");
				}
				if (project.getMakermano() != null) {
					VALUES("makermano", "#{makermano}");
				}
				if (project.getMaker() != null) {
					VALUES("maker", "#{maker}");
				}
				if (project.getContract() != null) {
					VALUES("contract", "#{contract}");
				}
				if (project.getQualitycost() != null) {
					VALUES("qualitycost", "#{qualitycost}");
				}
				if (project.getBak() != null) {
					VALUES("bak", "#{bak}");
				}
				if (project.getBak1() != null) {
					VALUES("bak1", "#{bak1}");
				}
				if (project.getBak2() != null) {
					VALUES("bak2", "#{bak2}");
				}
				if (project.getBak3() != null) {
					VALUES("bak3", "#{bak3}");
				}
				if (project.getBak4() != null) {
					VALUES("bak4", "#{bak4}");
				}
				if (project.getBak5() != null) {
					VALUES("bak5", "#{bak5}");
				}
				if (project.getBak6() != null) {
					VALUES("bak6", "#{bak6}");
				}
			}
		}.toString();
	}

	public String updateProject(Project project) {
		return new SQL() {
			{
				UPDATE("tb_project");
				if (project.getName() != null && !project.getName().equals("")) {
					SET("name = #{name}");
				}
				if (project.getCuscom() != null && !project.getCuscom().equals("")) {
					SET("cuscom = #{cuscom}");
				}
				if (project.getCustomer() != null && !project.getCustomer().equals("")) {
					SET("customer = #{customer}");
				}
				if (project.getCustel() != null && !project.getCustel().equals("")) {
					SET("custel = #{custel}");
				}
				if (project.getCusemail() != null && !project.getCusemail().equals("")) {
					SET("cusemail = #{cusemail}");
				}
				if (project.getCustomer1() != null && !project.getCustomer1().equals("")) {
					SET("customer1 = #{customer1}");
				}
				if (project.getCustel1() != null && !project.getCustel1().equals("")) {
					SET("custel1 = #{custel1}");
				}
				if (project.getCusemail1() != null && !project.getCusemail1().equals("")) {
					SET("cusemail1 = #{cusemail1}");
				}
				if (project.getPrice() != null && !project.getPrice().equals("")) {
					SET("price = #{price}");
				}
				if (project.getRcvmoney() != null && !project.getRcvmoney().equals("")) {
					SET("rcvmoney = #{rcvmoney}");
				}
				if (project.getSigndate() != null && !project.getSigndate().equals("")) {
					SET("signdate = #{signdate}");
				}
				if (project.getStartdate() != null && !project.getStartdate().equals("")) {
					SET("startdate = #{startdate}");
				}
				if (project.getEnddate() != null && !project.getEnddate().equals("")) {
					SET("enddate = #{enddate}");
				}
				if (project.getSalesmano() != null && !project.getSalesmano().equals("")) {
					SET("salesmano = #{salesmano}");
				}
				if (project.getSalesman() != null && !project.getSalesman().equals("")) {
					SET("salesman = #{salesman}");
				}
				if (project.getDesignmano() != null && !project.getDesignmano().equals("")) {
					SET("designmano = #{designmano}");
				}
				if (project.getDesignman() != null && !project.getDesignman().equals("")) {
					SET("designman = #{designman}");
				}
				if (project.getMakermano() != null && !project.getMakermano().equals("")) {
					SET("makermano = #{makermano}");
				}
				if (project.getMaker() != null && !project.getMaker().equals("")) {
					SET("maker = #{maker}");
				}
				if (project.getContract() != null && !project.getContract().equals("")) {
					SET("contract = #{contract}");
				}
				if (project.getQualitycost() != null && !project.getQualitycost().equals("")) {
					SET("qualitycost = #{qualitycost}");
				}
				if (project.getBak() != null && !project.getBak().equals("")) {
					SET("bak = #{bak}");
				}
				if (project.getBak1() != null && !project.getBak1().equals("")) {
					SET("bak1 = #{bak1}");
				}
				if (project.getBak2() != null && !project.getBak2().equals("")) {
					SET("bak2 = #{bak2}");
				}
				if (project.getBak3() != null && !project.getBak3().equals("")) {
					SET("bak3 = #{bak3}");
				}
				if (project.getBak4() != null && !project.getBak4().equals("")) {
					SET("bak4 = #{bak4}");
				}
				if (project.getBak5() != null && !project.getBak5().equals("")) {
					SET("bak5 = #{bak5}");
				}
				if (project.getBak6() != null && !project.getBak6().equals("")) {
					SET("bak6 = #{bak6}");
				}
				WHERE(" sequence = #{sequence} ");
			}
		}.toString();
	}
}
