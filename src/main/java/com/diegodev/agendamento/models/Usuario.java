package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusPapel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //cascade so para salvar e atualizar, assim evita de excluir um profissional e excluir o usuario junto
    private ProfissionalInfo profissionalInfo;

    @ManyToMany
    @JoinTable(name = "papel_usuario", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private Set<Papel> papeis = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentos = new ArrayList<>();
}

