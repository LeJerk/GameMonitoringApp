package com.jpj.enjoy.game.monitoring.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "customer")
public class Services
{

	//	@Id
	//	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	//	@Column(name = "name")
	private String name;

	//	@Column(name = "age")
	private int age;

	//	@Column(name = "active")
	private boolean active;

	public Services()
	{
	}

	public Services(String name, int age)
	{
		this.name = name;
		this.age = age;
		this.active = false;
	}

	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return this.age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	@Override
	public String toString()
	{
		return "Services [id=" + id + ", name=" + name + ", age=" + age + ", active=" + active + "]";
	}
}
