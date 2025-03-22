package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.repositories.TelefoneRepository;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;
    private final UsuarioRepository usuarioRepository;

    public void salvar(Telefone telefone){
        telefoneRepository.save(telefone);
    }

    public Telefone adicionarTelefone(Telefone telefone){

        Usuario usuario = usuarioRepository.findById(1L).get();
        usuario.getTelefones().add(telefone);
        telefone.setUsuario(usuario);
        return telefoneRepository.save(telefone);
    }

    public List<Telefone> obterTelefones(){
        Usuario usuario = usuarioRepository.findById(1L).get();

        return usuario.getTelefones();
    }

    public Telefone obterPorId(Long id){
        Usuario usuario = usuarioRepository.findById(1L).get();

        List<Telefone> telefones = usuario.getTelefones();

        return telefones
                .stream()
                .filter(telefone -> telefone.getId().equals(id))
                .findFirst()
                .get();
    }

    public Telefone atualizar(Long id, Telefone telefone){
        var telefoneEncontrado = obterPorId(id);

        atualizarTelefone(telefoneEncontrado, telefone);

        return telefoneRepository.save(telefoneEncontrado);
    }

    private void atualizarTelefone(Telefone telefoneEncontrado, Telefone telefone) {
        if(telefone.getNumero() != null) telefoneEncontrado.setNumero(telefone.getNumero());
    }

    public void deletar(Long id){
        telefoneRepository.delete(obterPorId(id));
    }
}
