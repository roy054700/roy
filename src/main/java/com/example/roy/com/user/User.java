package com.example.roy.com.user;

public class User {
private Integer id;
private Integer age ;
private String nama;

private Integer mix;
    private Integer mix22;

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
