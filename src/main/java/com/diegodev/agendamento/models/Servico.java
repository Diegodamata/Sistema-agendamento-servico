package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeServico;

    private String tempo;

    private Double precoBase;

    private String imgUrl;

    private StatusServico statusServico;

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "id.servico")
    private List<AgendamentoItem> items = new ArrayList<>();

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "servico")
    private List<Historico> historicos = new ArrayList<>();
}


