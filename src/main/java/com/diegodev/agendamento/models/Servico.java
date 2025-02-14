package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusServico;
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
@EqualsAndHashCode(of = "id")
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

    @NonNull
    private StatusServico statusServico;

    @JsonIgnore
    @OneToMany(mappedBy = "id.servico")
    private Set<AgendamentoItem> items = new HashSet<>();
}


