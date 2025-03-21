//package com.diegodev.agendamento.models;
//
//import com.diegodev.agendamento.models.pk.AgendamentoServicoPK;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.EmbeddedId;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "tb_agendamento_servico")
//public class AgendamentoServico {
//
//    @EmbeddedId
//    private AgendamentoServicoPK id = new AgendamentoServicoPK();
//
//    @Getter
//    @Setter
//    private Integer quantidade;
//    @Getter
//    @Setter
//    private Double precoBase;
//
//    public AgendamentoServico(Agendamento agendamento, Servico servico, Integer quantidade, Double precoBase) {
//        id.setAgendamento(agendamento);
//        id.setServico(servico);
//        this.quantidade = quantidade;
//        this.precoBase = precoBase;
//    }
//
//    @JsonIgnore
//    public Agendamento getAgendamento(){
//        return id.getAgendamento();
//    }
//
//    private void setAgendamento(Agendamento agendamento){
//        id.setAgendamento(agendamento);
//    }
//
//    public Servico getServico(){
//        return id.getServico();
//    }
//
//    private void setServico(Servico servico){
//        id.setServico(servico);
//    }
//
//    public Double getSubTotal(){
//        return precoBase * quantidade;
//    }
//}
