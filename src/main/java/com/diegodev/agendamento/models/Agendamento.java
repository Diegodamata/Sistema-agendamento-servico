package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusAgendamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAgendamento;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Builder.Default
    @ManyToMany
    @JoinTable(name = "profissional_agendamento", joinColumns = @JoinColumn(name = "agendamento_id"),
    inverseJoinColumns = @JoinColumn(name = "profissional_id"))
    private Set<ProfissionalInfo> profissionais = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "id.agendamento")
    private Set<AgendamentoItem> items = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "agendamento")
    private Set<Avaliacao> avaliacoes = new HashSet<>();
}
