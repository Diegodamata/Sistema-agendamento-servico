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

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final RoleService roleService;
    private final ProfissionalService profissionalService;
    private final TelefoneService telefoneService;
    private final EnderecoService enderecoService;

    public Usuario salvar(
            final Usuario usuario,
            final List<Role> roles,
            final Profissional profissional,
            final List<Telefone> telefones,
            final List<Endereco> enderecos){

        usuario.setStatus(StatusUsuario.ATIVO);
        repository.save(usuario);

        if(roles != null){
           for(Role role : roles){
               Role roleEncontrada = roleService.finByTipo(role.getTipo());
               usuario.getRoles().add(roleEncontrada);
               roleEncontrada.getUsuario().add(usuario);
           }
        }

        if(profissional != null){
            usuario.setProfissional(profissional);
            profissionalService.salvar(profissional);
        }

        if(telefones != null){
            usuario.getTelefones().addAll(telefones);
            for(Telefone telefone : telefones){
                telefone.setUsuario(usuario);
                telefoneService.salvar(telefone);
            }
        }

        if(enderecos != null){
            usuario.getEnderecos().addAll(enderecos);
            for(Endereco endereco : enderecos){
                endereco.setUsuario(usuario);
                enderecoService.salvar(endereco);
            }
        }

        return usuario;
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
