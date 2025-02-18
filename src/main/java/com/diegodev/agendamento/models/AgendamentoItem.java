package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.pk.AgendamentoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_agendamento_servico")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AgendamentoItem {

    @EmbeddedId
    private AgendamentoItemPK id = new AgendamentoItemPK();

    @Getter
    @Setter
    private Integer quantidade;
    @Getter
    @Setter
    private Double precoBase;

    public AgendamentoItem(Agendamento agendamento, Servico servico, Integer quantidade, Double precoBase) {
        id.setAgendamento(agendamento);
        id.setServico(servico);
        this.quantidade = quantidade;
        this.precoBase = precoBase;
    }

    @JsonIgnore
    public Agendamento getAgendamento(){
        return id.getAgendamento();
    }

    private void setAgendamento(Agendamento agendamento){
        id.setAgendamento(agendamento);
    }

    public Servico getServico(){
        return id.getServico();
    }

    private void setServico(Servico servico){
        id.setServico(servico);
    }

    public Double getSubTotal(){
        return precoBase * quantidade;
    }
}
