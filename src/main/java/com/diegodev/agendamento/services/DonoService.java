package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Dono;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.models.enums.TipoUsuario;
import com.diegodev.agendamento.repositories.DonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonoService {

    private final DonoRepository repository;
    private final UsuarioService usuarioService;
    private final TelefoneService telefoneService;

    public Dono salvarDono(Dono dono, Usuario usuario, List<Telefone> telefones){
        usuario.setStatus(StatusUsuario.ATIVO);
        usuario.setTipoUsuario(TipoUsuario.DONO);
        Usuario usuarioSalvo = usuarioService.salvar(usuario);
        dono.setUsuario(usuarioSalvo);

        if(telefones != null){
            for(Telefone telefone : telefones){
                telefone.setUsuario(usuarioSalvo);
                telefoneService.salvar(telefone);
            }
        }
        return repository.save(dono);
    }
}
