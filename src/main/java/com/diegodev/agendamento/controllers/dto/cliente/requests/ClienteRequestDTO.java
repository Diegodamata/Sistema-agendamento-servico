package com.diegodev.agendamento.controllers.dto.cliente.requests;

import com.diegodev.agendamento.controllers.dto.endereco.EnderecoRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public record ClienteRequestDTO(
        String nome,
        String email,
        String senha,
        List<TelefoneRequestDTO> telefones,
        List<EnderecoRequestDTO> enderecos
) {

    public Usuario toUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }

    public List<Telefone> toTelefones(){
        return telefones.stream()
                .map(dto -> new Telefone(dto.numero()))
                .collect(Collectors.toList());
    }

    public List<Endereco> toEndereco(){
        return enderecos.stream()
                .map(dto -> new Endereco(
                        dto.cep(),
                        dto.numero(),
                        dto.cidade()
                ))
                .collect(Collectors.toList());
    }
}
