package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Cliente;
import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.repositories.ClienteRepository;
import com.diegodev.agendamento.repositories.EnderecoRepository;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;
    private final ClienteRepository clienteRepository;

    public void salvar(Endereco endereco){
        repository.save(endereco);
    }

    public Endereco adicionarEndereco(Endereco endereco){
        Cliente cliente = clienteRepository.findById(1L).get();

        cliente.getEnderecos().add(endereco);
        endereco.setCliente(cliente);
        return repository.save(endereco);
    }

    public List<Endereco> obterEndereco() {
        Cliente cliente = clienteRepository.findById(1L).get();
        return cliente.getEnderecos();
    }

    public Endereco obterPorId(Long id){
        Cliente cliente = clienteRepository.findById(1L).get();

        List<Endereco> enderecos = cliente.getEnderecos();

        return enderecos
                .stream()
                .filter(endereco -> endereco.getId().equals(id))
                .findFirst()
                .get();
    }

    public Endereco atualizar(Long id, Endereco endereco){
        var enderecoEncontrado = obterPorId(id);

        atualizarEndereco(enderecoEncontrado, endereco);

        return repository.save(enderecoEncontrado);
    }

    private void atualizarEndereco(Endereco enderecoEncontrado, Endereco endereco) {
        if(endereco.getCidade() != null) enderecoEncontrado.setCidade(endereco.getCidade());
    }

    public void deletar(Long id){
        repository.delete(obterPorId(id));
    }
}