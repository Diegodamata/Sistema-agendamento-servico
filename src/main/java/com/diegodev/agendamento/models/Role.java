package com.diegodev.agendamento.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private final List<Usuario> usuarios = new ArrayList<>();
}
