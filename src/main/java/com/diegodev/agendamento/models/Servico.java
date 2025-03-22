//package com.diegodev.agendamento.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "servicos")
//@Data
//@EntityListeners(AuditingEntityListener.class)
//public class Servico {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nomeServico;
//
//    private String tempo;
//
//    private BigDecimal precoBase;
//
////    private String imgUrl;
//
//    @ManyToMany
//    @JoinTable(name = "servico_tipo_servico", joinColumns = @JoinColumn(name = "servico_id"),
//    inverseJoinColumns = @JoinColumn(name = "tipoServico_id"))
//    private final List<TipoServico> tipoServicos = new ArrayList<>();
//
//    @CreatedDate
//    private LocalDateTime dataCadastro;
//
//    @LastModifiedDate
//    private LocalDateTime dataAtualizacao;
//
////    @JsonIgnore
////    @OneToMany(mappedBy = "id.servico")
////    private final List<AgendamentoServico> agendamentos = new ArrayList<>();
//
////    @JsonIgnore
////    @OneToMany(mappedBy = "servico")
////    private final List<Historico> historicos = new ArrayList<>();
//}
//
//
