package com.diegodev.agendamento.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    private String cidade;

    @NonNull
    private String rua;
    @NonNull
    private Integer numero;
    @NonNull
    private String complemento;
    @NonNull
    private String cep;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
