package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco salvar(Endereco endereco){
        return repository.save(endereco);
    }

//    public List<Endereco> obterEndereco() {
//        Usuario usuario = usuarioRepository.findById(1L).get();
//        return usuario.getEnderecos();
//    }
//
//    public Endereco obterPorId(Long id){
//        Usuario usuario = usuarioRepository.findById(1L).get();
//
//        List<Endereco> enderecos = usuario.getEnderecos();
//
//        return enderecos
//                .stream()
//                .filter(endereco -> endereco.getId().equals(id))
//                .findFirst()
//                .get();
//    }
//
//    public Endereco atualizar(Long id, Endereco endereco){
//        var enderecoEncontrado = obterPorId(id);
//
//        atualizarEndereco(enderecoEncontrado, endereco);
//
//        return repository.save(enderecoEncontrado);
//    }
//
//    private void atualizarEndereco(Endereco enderecoEncontrado, Endereco endereco) {
//        if(endereco.getCidade() != null) enderecoEncontrado.setCidade(endereco.getCidade());
//    }
//
//    public void deletar(Long id){
//        repository.delete(obterPorId(id));
//    }
}