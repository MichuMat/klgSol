package com.example.demo.entities.idclasses;

import com.example.demo.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserId implements Serializable {
    private String name;
    private Role role;
}
