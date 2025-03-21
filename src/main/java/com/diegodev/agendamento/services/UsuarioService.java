package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.models.enums.TipoUsuario;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario salvar(Usuario usuario){
        usuario.setStatus(StatusUsuario.ATIVO);
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);
        return repository.save(usuario);
    }
}
