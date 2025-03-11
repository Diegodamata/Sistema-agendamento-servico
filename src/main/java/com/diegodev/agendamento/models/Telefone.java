package com.diegodev.agendamento.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "telefones")
@Data
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
