package com.diegodev.agendamento.controllers.dto.telefone.requests;

import com.diegodev.agendamento.models.Telefone;

public record TelefoneRequestDTO(
        String numero
) {

    public Telefone toTelefone(){
        Telefone telefone = new Telefone();
        telefone.setNumero(numero);
        return telefone;
    }
}
