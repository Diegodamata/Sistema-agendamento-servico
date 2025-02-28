//package com.diegodev.agendamento.models;
//
//import com.diegodev.agendamento.models.enums.StatusServico;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "servicos")
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
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
//    private Double precoBase;
//
////    private String imgUrl;
//
//    private StatusServico statusServico;
//
//    @CreatedDate
//    private LocalDateTime dataCadastro;
//
//    @LastModifiedDate
//    private LocalDateTime dataAtualizacao;
//
//    @Builder.Default
//    @JsonIgnore
//    @OneToMany(mappedBy = "id.servico")
//    private List<AgendamentoItem> items = new ArrayList<>();
//
////    @Builder.Default
////    @JsonIgnore
////    @OneToMany(mappedBy = "servico")
////    private List<Historico> historicos = new ArrayList<>();
//}
//
//
