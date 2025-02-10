package com.diegodev.agendamento.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "servicos")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    private String nomeServico;
    @NonNull
    private String tempo;
    @NonNull
    private Double precoBase;
    @NonNull
    private String imgUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "id.servico")
    private Set<AgendamentoItem> items = new HashSet<>();
}


