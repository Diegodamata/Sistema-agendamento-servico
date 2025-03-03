package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco criarEndereco(Endereco endereco){
        return repository.save(endereco);
    }

    public List<Endereco> obterEndereco(){
        return repository.findAll();
    }

    public Endereco alterar(Long id, Endereco endereco){
        Endereco enderecoEncontrado = repository.findById(id).orElse(null);

        alterarEndereco(enderecoEncontrado, endereco);

        return repository.save(enderecoEncontrado);
    }

    private void alterarEndereco(Endereco enderecoEncontrado, Endereco endereco) {
        if(endereco.getCep() != null) enderecoEncontrado.setCep(endereco.getCep());
        if(endereco.getNumero() != null) enderecoEncontrado.setNumero(endereco.getNumero());
        if(endereco.getCidade() != null) enderecoEncontrado.setCidade(endereco.getCidade());
    }

    public void deletar(Long id){
        Endereco enderecoEncontrado = repository.findById(id).orElse(null);
        repository.delete(enderecoEncontrado);
    }
}
