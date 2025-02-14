package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusPapel;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    private String nome;

    @NonNull
    private String cpf;

    @NonNull
    private String email;

    @NonNull
    private String senha;

    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ProfissionalInfo profissionalInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "papel_usuario", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private Set<Papel> papeis = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Telefone> telefones = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Endereco> enderecos = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private Set<Agendamento> agendamentos = new HashSet<>();
}

