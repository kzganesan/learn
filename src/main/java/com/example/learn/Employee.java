package com.example.learn;


import javax.persistence.*;

@Entity
@Table(name="book")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(name="book_name")
    String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
