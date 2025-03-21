package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.models.enums.TipoUsuario;
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
import java.util.List;

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

    @OneToMany(mappedBy = "usuario")
    private List<Telefone> telefones = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @CreatedDate
    private LocalDate dataCadastro;

    @LastModifiedDate
    private LocalDate dataAtualizacao;
}

