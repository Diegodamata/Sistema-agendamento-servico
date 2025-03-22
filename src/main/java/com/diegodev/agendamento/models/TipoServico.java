//package com.diegodev.agendamento.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "tipo_servicos")
//@Data
//public class TipoServico {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String tipoServico;
//
//    @ManyToMany(mappedBy = "tipoServicos")
//    private final List<Servico> servicos = new ArrayList<>();
//}
