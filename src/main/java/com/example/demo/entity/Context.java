package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name="contexts")
public class Context {
    @GeneratedValue(generator="contexts_seq_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="contexts_seq_gen",sequenceName="contexts_seq",allocationSize = 1)
    @Id
    private Integer id;

    @Column(name="context_name",nullable=false,length=100)
    private String name;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "information_id",
//            referencedColumnName = "id",
//            foreignKey = @ForeignKey(name = "fk_contexts_information_id"))
//    private Information information;
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "contexts_informations",
        foreignKey = @ForeignKey(name = "FK_contexts_informations_context_id"),
        joinColumns = @JoinColumn(name = "context_id", referencedColumnName = "id"),
        inverseForeignKey = @ForeignKey(name = "FK_contexts_informations_information_id"),
        inverseJoinColumns = @JoinColumn(name = "information_id", referencedColumnName = "id"),
        uniqueConstraints = @UniqueConstraint(name = "UNIQUE_contexts_informations_context_id_information_id",
                columnNames = {"context_id", "information_id"})
)
private Collection<Information> informations;
}
