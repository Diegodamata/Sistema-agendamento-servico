package com.diegodev.agendamento.controllers.dto.dono;

import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.models.Dono;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public record DonoRequestDTO(
        String nome,
        String email,
        String senha,
        String cnpj,
        List<TelefoneRequestDTO> telefones
) {

    public Usuario toUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }

    public Dono toDono(){
        Dono dono = new Dono();
        dono.setCnpj(cnpj);
        return dono;
    }

    public List<Telefone> toTelefones(){
        return telefones.stream()
                .map(dto -> new Telefone(dto.numero()))
                .collect(Collectors.toList());
    }
}
