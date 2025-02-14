package com.diegodev.agendamento.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "profissionais")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfissionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id")
    @MapsId //tanto o profissional quanto o usuario possuai o mesmo id
    private Usuario usuario;

    @NonNull
    private String nomeEmpresa;

//    private String cargo;
//
//    private String especialidade;
//
//    private String cnpj;

    @JsonIgnore
    @ManyToMany(mappedBy = "profissionais")
    private Set<Agendamento> agendamentos = new HashSet<>();
}
