package com.diegodev.agendamento.controllers.dto.endereco;

import com.diegodev.agendamento.models.Endereco;

public record EnderecoRequestDTO(
        String cep,
        Integer numero,
        String cidade
) {

    public Endereco toEndereco(){
        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);

        return endereco;
    }
}
