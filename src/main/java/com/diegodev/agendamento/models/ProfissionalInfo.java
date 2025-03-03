package com.diegodev.agendamento.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profissionais")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProfissionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id")
    @MapsId //tanto o profissional quanto o usuario possuai o mesmo id
    private Usuario usuario;

    private String nomeEmpresa;

//    private String cargo;
//
//    private String especialidade;
//
//    private String cnpj;

//    @Builder.Default
//    @JsonIgnore
//    @ManyToMany(mappedBy = "profissionais")
//    private List<Agendamento> agendamentos = new ArrayList<>();
//
//    @Builder.Default
//    @JsonIgnore
//    @OneToMany(mappedBy = "profissional")
//    private List<Historico> historicos = new ArrayList<>();
}
