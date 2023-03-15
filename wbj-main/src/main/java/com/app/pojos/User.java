package com.app.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "user_id")
    private Long id;
    @Column(nullable = false, length = 255)
    @JoinColumn(name = "user_name")
    private String name;
    @Column(nullable = false, length = 255, unique = true)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false, length = 15)
    private String contactno;
    @Column(nullable = false)
    private Long age;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
    @Column(nullable = false, length = 255)
    private String address;
    @Column(nullable = false, length = 255)
    private String location;
    @Column(nullable = false, length = 255)
    private String gender;

    public User() {

    }

    // getters and setters

    public User(Long id, String name, String email, String password, String contactno, Date createDate,
                String address, String location, String gender, Long age) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.contactno = contactno;
        this.createDate = createDate;
        this.address = address;
        this.location = location;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", contactno="
                + contactno + ", age=" + age + ", createDate=" + createDate + ", address=" + address + ", location="
                + location + ", gender=" + gender + "]";
    }

}