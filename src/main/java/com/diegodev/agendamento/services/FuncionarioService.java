package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.*;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.models.enums.TipoUsuario;
import com.diegodev.agendamento.repositories.ConviteRepository;
import com.diegodev.agendamento.repositories.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final ConviteRepository conviteRepository;
    private final UsuarioService usuarioService;
    private final TelefoneService telefoneService;

    public Funcionario salvarFuncionario(String token, Funcionario funcionario, Usuario usuario, List<Telefone> telefones){

        Convite convite = conviteRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Convite invalido ou expirado!"));

        if(convite.isUsado() || convite.getDataExpiracao().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Convite ja usado ou expirado!");
        }

        convite.setUsado(true);

        usuario.setStatus(StatusUsuario.ATIVO);
        usuario.setTipoUsuario(TipoUsuario.FUNCIONARIO);
        Usuario usuarioSalvo = usuarioService.salvar(usuario);

        Dono dono = convite.getDono();

        if(telefones != null){
            for(Telefone telefone : telefones){
                telefone.setUsuario(usuarioSalvo);
                telefoneService.salvar(telefone);
            }
        }

        funcionario.setUsuario(usuarioSalvo);
        funcionario.setDono(dono);

        return repository.save(funcionario);
    }
}
