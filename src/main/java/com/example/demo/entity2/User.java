package com.example.demo.entity2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="users_seq_gen")
    @SequenceGenerator(name="users_seq_gen",sequenceName="users_seq",allocationSize=1)
    @Id
    private Integer id;
    @Column(name="user_name" ,nullable=false, length=100)
    private String name;
}


