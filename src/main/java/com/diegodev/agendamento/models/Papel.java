package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusPapel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tipo_usuario")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class Papel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusPapel statusPapel;

    @ManyToMany(mappedBy = "papeis")
    private Set<Usuario> usuarios = new HashSet<>();
}
