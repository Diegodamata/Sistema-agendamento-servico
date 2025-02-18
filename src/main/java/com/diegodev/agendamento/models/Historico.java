package com.diegodev.agendamento.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * A tabela historico precisa conter o id e nome do usuario (para saber que se tatra de um usuario especifico)
 * O id e nome do profissional qu fez o serviço
 * O id e data e hora e status e quantidade do agendamento
 * o id a nota e a mensagem da avaliação do usuario
 * o id, nome, tempo, preço e status do serviço
 * id, data e hora e status do pagamento
 * data criacao da tabela historico
 */

@Entity
@Table(name = "historicos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private ProfissionalInfo profissional;

    @ManyToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "id_avaliacao")
    private Avaliacao avaliacao;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataEHoraCadastro;
}
