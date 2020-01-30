package net.codejava.spring.model;

public class Employee {

	private int id;
	private String f_name;
	private String l_name;
	private String email;
	private String telephone;

	
	
	public Employee(String f_name, String l_name, String email, String telephone) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.telephone = telephone;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}