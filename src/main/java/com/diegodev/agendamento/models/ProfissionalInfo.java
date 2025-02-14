package com.diegodev.agendamento.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "profissional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProfissionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    @MapsId //tanto o profissional quanto o usuario possuai o mesmo id
    private Usuario usuario;

    private String nomeEmpresa;

    private String cargo;

    private String especialidade;

    private String cnpj;
}
