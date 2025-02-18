package com.diegodev.agendamento.models;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ProfissionalInfo profissionalInfo;

    @Builder.Default //com isso o lombok informa para usar o valor padrão, quando não é iniciado um valor, assim evita o nullPointerException
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "papel_usuario", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private Set<Papel> papeis = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario")
    private Set<Telefone> telefones = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario")
    private Set<Endereco> enderecos = new HashSet<>();

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentos = new ArrayList<>();

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private Set<Avaliacao> avaliacoes = new HashSet<>();
}

