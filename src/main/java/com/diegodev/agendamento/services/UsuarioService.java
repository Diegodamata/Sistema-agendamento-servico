package com.diegodev.agendamento.services;

import com.diegodev.agendamento.controllers.dto.usuario.responses.UsuarioResponseDTO;
import com.diegodev.agendamento.models.*;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import com.diegodev.agendamento.repositories.specs.UsuarioSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario criarUsuario(
            final Usuario usuario,
            final List<Papel> papeis,
            final ProfissionalInfo profissional,
            final List<Telefone> telefones,
            final List<Endereco> enderecos){

        usuario.setStatus(StatusUsuario.ATIVO);
        repository.save(usuario);

        if(papeis != null){
            usuario.getPapeis().addAll(papeis);
        }

        if(profissional != null){
            profissional.setUsuario(usuario);
            usuario.setProfissionalInfo(profissional);
        }

        if(telefones != null){
            telefones.forEach(tel -> tel.setUsuario(usuario));
            usuario.getTelefones().addAll(telefones);
        }

        if(enderecos != null){
            enderecos.forEach(end -> end.setUsuario(usuario));
            usuario.getEnderecos().addAll(enderecos);
        }

        return repository.save(usuario);
    }

    public Page<Usuario> obterUsuario(String nome, int pagina, int tamanho){

        //Faz uma consulta ex: select * from usuario where 0 = 0;
        Specification<Usuario> specs = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if (nome != null){
            specs = specs.and(UsuarioSpecs.nome(nome));
        }

        Pageable pageable = PageRequest.of(pagina, tamanho);

        return repository.findAll(specs, pageable);
    }

    public Usuario obterPorId(Long id) {
        return repository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuario Não encontrado"));
    }

    public Usuario atualizar(Long id, Usuario usuario){

        Usuario usuarioEncontrado = obterPorId(id);

        atualizarUsuario(usuarioEncontrado, usuario);

        return repository.save(usuarioEncontrado);
    }

    private static void atualizarUsuario(Usuario usuarioEncontrado, Usuario usuario) {
        if(usuario.getNome() != null) usuarioEncontrado.setNome(usuario.getNome());
        if(usuario.getEmail() != null) usuarioEncontrado.setEmail(usuario.getEmail());
        if(usuario.getSenha() != null) usuarioEncontrado.setSenha(usuario.getSenha());
    }

    public void deletar(Long id){
        repository.delete(obterPorId(id));
    }


//    public Optional<Usuario> obterPorId(Long id){
//        return repository.findById(id);
//    }
//
//
//    public Page<Usuario> obterUsuarios(String nome, Pageable pageable) {
//        if(nome != null && !nome.isEmpty()){
//            return filtrarUsuarioPorNome(nome, pageable);
//        }
//        return repository.findAll(pageable);
//    }
//
//    public Page<Usuario> filtrarUsuarioPorNome(String nome, Pageable pageable){
//        return repository.findByNomeContainingIgnoreCase(nome, pageable);
//    }
//
//    public void alterarDadosUsuario(Usuario usuario) {
//        repository.save(usuario);
//    }
}
