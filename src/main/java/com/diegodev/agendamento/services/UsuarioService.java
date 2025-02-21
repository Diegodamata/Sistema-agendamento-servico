package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.*;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario criarUsuario(final Usuario usuario,
                                final List<Papel> papel,
                                final ProfissionalInfo profissional,
                                final List<Telefone> telefone,
                                final List<Endereco> endereco){
        usuario.setStatus(StatusUsuario.ATIVO);
        var cadastroUsuario = repository.save(usuario);
        if(profissional != null){
            cadastroUsuario.setProfissionalInfo(profissional);
        }
        if(papel != null){
            for (Papel p : papel){
                cadastroUsuario.getPapeis().add(p);
            }
        }
        else{
            throw new IllegalArgumentException("lista vazia");
        }

        if(telefone != null){
            for (Telefone tele : telefone){
                cadastroUsuario.getTelefones().add(tele);
            }
        }
        else{
            throw new IllegalArgumentException("Lista vazia telefone");
        }

        if(endereco != null){
            for (Endereco end : endereco){
                cadastroUsuario.getEnderecos().add(end);
            }
        } else{
            throw new IllegalArgumentException("Lista vazia telefone");
        }
        return cadastroUsuario;
    }
}
