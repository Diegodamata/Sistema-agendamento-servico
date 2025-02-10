package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    private String nome;

    @NonNull
    private String email;

    @NonNull
    private String senha;

    @NonNull
    @Column(name = "tipo_usuario")
    @Enumerated(EnumType.STRING)
    private StatusUsuario statusUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos = new ArrayList<>();
}

