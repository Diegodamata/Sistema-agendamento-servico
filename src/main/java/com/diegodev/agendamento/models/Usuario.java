package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @OneToOne(mappedBy = "usuario")
    private ProfissionalInfo profissionalInfo;

    @Builder.Default //com isso o lombok informa para usar o valor padrão, quando não é iniciado um valor, assim evita o nullPointerException
    @ManyToMany
    @JoinTable(name = "papel_usuario", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private List<Papel> papeis = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario")
    private List<Telefone> telefones = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos = new ArrayList<>();

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentos = new ArrayList<>();

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Historico> historicos = new ArrayList<>();

//    Dados para auditoria
    @CreatedDate
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    private LocalDateTime dataAtualizacao;
//
//    private Long idUsuario; (Para o security)
}

