package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusAgendamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agendamentos")
@Data
@Builder
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAgendamento;

    @Column(name = "statusAgendamento")
    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

//    @ManyToMany
//    @JoinTable(name = "profissional_agendamento", joinColumns = @JoinColumn(name = "agendamento_id"),
//    inverseJoinColumns = @JoinColumn(name = "profissional_id"))
//    private List<ProfissionalInfo> profissionais = new ArrayList<>();

    @OneToMany(mappedBy = "id.agendamento")
    private final List<AgendamentoServico> servicos = new ArrayList<>();

//    @OneToMany(mappedBy = "agendamento")
//    private List<Avaliacao> avaliacoes = new ArrayList<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "agendamento")
//    private List<Historico> historicos = new ArrayList<>();
}
