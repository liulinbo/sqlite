package com.nimos.sqlite.bean;

import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;

/**
 * 
 * @ClassName: User
 * @Author linbo.liu
 * @Date 2014-11-27
 * @Desc: TODO
 */
@Table(name="User_Table")
public class User{
	@Id(column="id")
    private int id;
	private int age;
    private String name;
    private String department;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}