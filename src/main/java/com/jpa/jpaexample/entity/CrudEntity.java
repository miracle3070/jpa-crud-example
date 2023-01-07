package com.jpa.jpaexample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="sample_member")
public class CrudEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;


}
