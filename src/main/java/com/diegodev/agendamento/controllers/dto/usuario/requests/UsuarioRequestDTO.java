package com.diegodev.agendamento.controllers.dto.usuario.requests;

import com.diegodev.agendamento.controllers.dto.endereco.EnderecoRequestDTO;
import com.diegodev.agendamento.controllers.dto.profissional.ProfissionalRequestDTO;
import com.diegodev.agendamento.controllers.dto.role.requests.RoleRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.models.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) //o json não ira incluir valores nulos
public record UsuarioRequestDTO(
         String nome,
         String email,
         String senha,
         List<RoleRequestDTO> roles,
         ProfissionalRequestDTO profissional,
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
}
