//package com.diegodev.agendamento.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "avaliacoes")
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//public class Avaliacao {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Byte nota;
//
//    private String mensagem;
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "id_usuario")
//    private Usuario usuario;
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "id_agendamento")
//    private Agendamento agendamento;
//
//    @Builder.Default
//    @JsonIgnore
//    @OneToMany(mappedBy = "avaliacao")
//    private List<Historico> historicos = new ArrayList<>();
//}
