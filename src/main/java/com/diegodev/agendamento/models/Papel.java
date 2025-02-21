package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusPapel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "papeis")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Papel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusPapel statusPapel;

    @Builder.Default
    @JsonIgnore
    @ManyToMany(mappedBy = "papeis")
    private List<Usuario> usuarios = new ArrayList<>();
}
