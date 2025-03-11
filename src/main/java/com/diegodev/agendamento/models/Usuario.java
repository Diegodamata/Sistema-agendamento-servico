package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusUsuario;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private final List<Role> roles = new ArrayList<>();

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ProfissionalInfo profissionalInfo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private final List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
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
    @CreatedDate
    private LocalDate dataCadastro;

    @LastModifiedDate
    private LocalDate dataAtualizacao;
}

