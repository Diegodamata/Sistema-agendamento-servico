package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusUsuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @ManyToMany
    @JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id")
    ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @CreatedDate
    private LocalDate dataCadastro;

    @LastModifiedDate
    private LocalDate dataAtualizacao;

    @OneToOne(mappedBy = "usuario")
    private Profissional profissional;

    @OneToMany(mappedBy = "usuario")
    private final List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private final List<Endereco> enderecos = new ArrayList<>();
//
//    @Builder.Default
//    @JsonIgnore
//    @OneToMany(mappedBy = "usuario")
//    private List<Agendamento> agendamentos = new ArrayList<>();
//
//    @Builder.Default
//    @JsonIgnore
//    @OneToMany(mappedBy = "usuario")
//    private List<Avaliacao> avaliacoes = new ArrayList<>();
//
//    @Builder.Default
//    @JsonIgnore
//    @OneToMany(mappedBy = "usuario")
//    private List<Historico> historicos = new ArrayList<>();

//    Dados para auditoria
}

