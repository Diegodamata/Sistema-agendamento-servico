package com.diegodev.agendamento.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profissionais")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEmpresa;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

//    private String cargo;
//
//    private String especialidade;
//
//    private String cnpj;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "profissionais")
//    private List<Agendamento> agendamentos = new ArrayList<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "profissional")
//    private List<Historico> historicos = new ArrayList<>();
}
