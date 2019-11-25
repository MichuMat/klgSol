package com.example.demo.entities;

import com.example.demo.entities.idclasses.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(UserId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String name;

    @Id
    @ManyToOne
    private Role role;
}
