package com.example.roy.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String id;
	protected String name;
	protected String age;

    protected String firstName;

    protected String lastName;

    protected String email;

    protected String fullName;
    protected String password;
    
    protected List<String> privileges = new ArrayList<>();
    
//    public User(User user) {
//        id=user.getId();
//        rev = user.getRev();
//        first = user.getFirst();
//        last=user.getLast();
//        fullName =user.getFirst()+ " " + user.getLast() ;
//        email =user.getEmail();
//        pwd = user.getPwd();
//        pictureId = user.getPictureId();
//        tenantId = user.getTenantId();
//        
//    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public List<String> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<String> privileges) {
		this.privileges = privileges;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", fullName=" + fullName + ", password=" + password + ", privileges="
				+ privileges + "]";
	}
	

    
}