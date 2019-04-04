package com.jonny.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "person")
@EntityListeners(AuditingEntityListener.class)
public class Person{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    private String longName;

    private String fullName;

    public Person(){
        //must have
    }
    /*
    public Person(int id, String name, String longName, String fullName) {
        this.id = id;
        this.name = name;
        this.longName = longName;
        this.fullName = fullName;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}