package com.example.roy.com.user;

public class User {
private Integer id;
private Integer age ;
private String nama;

private Integer mix;
    private Integer mix22;
    
    
    

    /**
	 * @return the mix
	 */
	public Integer getMix() {
		return mix;
	}

	/**
	 * @param mix the mix to set
	 */
	public void setMix(Integer mix) {
		this.mix = mix;
	}

	/**
	 * @return the mix22
	 */
	public Integer getMix22() {
		return mix22;
	}

	/**
	 * @param mix22 the mix22 to set
	 */
	public void setMix22(Integer mix22) {
		this.mix22 = mix22;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }







    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", nama='" + nama + '\'' +
                '}';
    }
}
