package com.app.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "admin_id")
    private Long id;
    @Column(length = 255, nullable = false)
    @JoinColumn(name = "admin_name")
    private String name;
    @Column(length = 255, nullable = false, unique = true)
    private String email;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 15, nullable = false)
    private String contactno;
    @Column(length = 15, nullable = false)
    private String age;
    @Temporal(TemporalType.TIMESTAMP)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "create_date")
    private Date createDate;
    @Column(length = 255, nullable = false)
    private String location;
    @Column(length = 255, nullable = false)
    private String address;
    @Column(length = 255, nullable = false)
    private String gender;

    public Admin() {

    }


    public Admin(Long id, String name, String email, String password, String contactno, Date createDate,
                 String location, String address, String gender, String age) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.contactno = contactno;
        this.createDate = createDate;
        this.location = location;
        this.address = address;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", contactno="
                + contactno + ", age=" + age + ", createDate=" + createDate + ", location=" + location + ", address="
                + address + ", gender=" + gender + "]";
    }


}
