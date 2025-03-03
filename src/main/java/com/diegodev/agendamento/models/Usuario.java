package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ProfissionalInfo profissionalInfo;

    @Builder.Default //com isso o lombok informa para usar o valor padrão, quando não é iniciado um valor, assim evita o nullPointerException
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "papel_usuario", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private List<Papel> papeis = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Telefone> telefones = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();
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
//
//    private Long idUsuario; (Para o security)
}

