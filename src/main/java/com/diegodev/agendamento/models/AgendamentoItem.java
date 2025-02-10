package com.diegodev.agendamento.models;

import com.diegodev.agendamento.models.pk.AgendamentoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_agendamento_servico")
public class AgendamentoItem {

    @EmbeddedId
    private AgendamentoItemPK id = new AgendamentoItemPK();

    private Integer quantidade;
    private Double precoBase;

    public AgendamentoItem(){
    }

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

    public void setAgendamento(Agendamento agendamento){
        id.setAgendamento(agendamento);
    }


    public Servico getServico(){
        return id.getServico();
    }

    public void setServico(Servico servico){
        id.setServico(servico);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AgendamentoItem that = (AgendamentoItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
