package com.diegodev.agendamento.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_servicos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoServico;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
}
