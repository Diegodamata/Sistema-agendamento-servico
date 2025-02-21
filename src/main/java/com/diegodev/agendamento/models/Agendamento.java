package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusAgendamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private List<ProfissionalInfo> profissionais = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "id.agendamento")
    private List<AgendamentoItem> items = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "agendamento")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "agendamento")
    private List<Historico> historicos = new ArrayList<>();
}
