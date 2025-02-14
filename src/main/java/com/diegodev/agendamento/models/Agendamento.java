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
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    private LocalDateTime dataAgendamento;

    @NonNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "id.agendamento")
    private Set<AgendamentoItem> items = new HashSet<>();
}
