package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="informations")
public class Information {
    @GeneratedValue(generator="infomations_seq_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="infomations_seq_gen",sequenceName="infomations_seq",allocationSize = 1)
    @Id
    private Integer id;

    @Column(name="infomation_name",nullable=false,length=100)
    private String name;

    @Column(name="age",length=10,nullable=false)
    private Integer age;
}

