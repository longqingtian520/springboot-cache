package com.criss.wang.entity;

public class User extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = -1395679041017394017L;

	private String name;

	private int age;

	private String datasource;

	public User() {
		super();
	}

	public User(String name, int age, String datasource) {
		super();
		this.name = name;
		this.age = age;
		this.datasource = datasource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
}
