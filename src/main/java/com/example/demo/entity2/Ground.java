package com.example.demo.entity2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="grounds")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Ground {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="grounds_seq_gen")
    @SequenceGenerator(name="grounds_seq_gen",sequenceName="grounds_seq",allocationSize=1)
    @Id
    private Integer id;

    @Column(name ="ground_name",nullable = false,length = 100)
    private String ground_name;
}
