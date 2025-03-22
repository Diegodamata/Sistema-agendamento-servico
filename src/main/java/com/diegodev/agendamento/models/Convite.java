package com.diegodev.agendamento.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "convites")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Convite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dono_id")
    private Dono dono;

    private LocalDateTime dataExpiracao;

    private boolean usado = false;
}
