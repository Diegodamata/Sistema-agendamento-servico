package com.diegodev.agendamento.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profissionais")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
