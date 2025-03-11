package com.diegodev.agendamento.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enderecos")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private Integer numero;

//    private String complemento;

    private String cidade;

//    private String bairro;

//    private String rua;

//    private String estado;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
