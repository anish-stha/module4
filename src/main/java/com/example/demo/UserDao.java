package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    @Column(name = "NAME")
    String name;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "LOCATION")
    String location;

    @Column(name = "GENDER")
    String gender;

    @Column(name = "EXPERIENCE")
    String experience;
}
