package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.*;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import com.diegodev.agendamento.repositories.specs.UsuarioSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final RoleService roleService;

    public Usuario criarUsuario(
            final Usuario usuario,
            final List<String> roles,
            final ProfissionalInfo profissional,
            final List<Telefone> telefones,
            final List<Endereco> enderecos){

        List<Role> listRole = new ArrayList<>();
        for (String role : roles){
            if(role != null){
                Role byRole = roleService.findByRole(role);
                listRole.add(byRole);
            }
        }
        usuario.getRoles().addAll(listRole);

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
        usuario.setStatus(StatusUsuario.ATIVO);
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
}
