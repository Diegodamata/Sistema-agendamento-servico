package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Cliente;
import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.models.enums.TipoUsuario;
import com.diegodev.agendamento.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final UsuarioService usuarioService;
    private final TelefoneService telefoneService;
    private final EnderecoService enderecoService;

    public Cliente salvarCliente(Usuario usuario, List<Telefone> telefones, List<Endereco> enderecos){
        usuario.setStatus(StatusUsuario.ATIVO);
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);
        Usuario usuarioSalvo = usuarioService.salvar(usuario);

        if(telefones != null){
            for(Telefone telefone : telefones){
                telefone.setUsuario(usuarioSalvo);
                telefoneService.salvar(telefone);
            }
        }

        Cliente cliente = new Cliente();
        cliente.setUsuario(usuarioSalvo);
        cliente = repository.save(cliente);

        if(enderecos != null){
            for(Endereco endereco : enderecos){
                endereco.setCliente(cliente);
                enderecoService.salvar(endereco);
            }
        }

        return cliente;
    }

//    public Page<Usuario> obterUsuario(String nome, int pagina, int tamanho){
//
//        //Faz uma consulta ex: select * from usuario where 0 = 0;
//        Specification<Usuario> specs = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
//
//        if (nome != null){
//            specs = specs.and(UsuarioSpecs.nome(nome));
//        }
//
//        Pageable pageable = PageRequest.of(pagina, tamanho);
//
//        return repository.findAll(specs, pageable);
//    }
//
//    public Usuario obterPorId(Long id) {
//        return repository.findById(id)
//                .orElseThrow( () -> new RuntimeException("Usuario Não encontrado"));
//    }
//
//    public Usuario atualizar(Long id, Usuario usuario){
//
//        Usuario usuarioEncontrado = obterPorId(id);
//
//        atualizarUsuario(usuarioEncontrado, usuario);
//
//        return repository.save(usuarioEncontrado);
//    }
//
//    private static void atualizarUsuario(Usuario usuarioEncontrado, Usuario usuario) {
//        if(usuario.getNome() != null) usuarioEncontrado.setNome(usuario.getNome());
//        if(usuario.getEmail() != null) usuarioEncontrado.setEmail(usuario.getEmail());
//        if(usuario.getSenha() != null) usuarioEncontrado.setSenha(usuario.getSenha());
//    }
//
//    public void deletar(Long id){
//        repository.delete(obterPorId(id));
//    }
}
