package com.diegodev.agendamento.controllers.dto.funcionario.requests;

import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.models.Funcionario;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public record FuncionarioRequestDTO(
        String nome,
        String email,
        String senha,
        String cargo,
        String especialidade,
        List<TelefoneRequestDTO> telefones
) {

    public Usuario toUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }

    public Funcionario toFuncionario(){
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(cargo);
        funcionario.setEspecialidade(especialidade);
        return funcionario;
    }

    public List<Telefone> toTelefones(){
        return telefones.stream()
                .map(dto -> new Telefone(dto.numero()))
                .collect(Collectors.toList());
    }
}
