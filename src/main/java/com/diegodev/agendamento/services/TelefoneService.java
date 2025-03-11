package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.repositories.TelefoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneService {

    private final TelefoneRepository repository;

    public Telefone criarTelefone(Telefone telefone) {
        return repository.save(telefone);
    }

    public List<Telefone> obterTelefone(){
        return repository.findAll();
    }

    public Telefone alterar(Long id, Telefone telefone){
       var telefoneEndontrado = repository.findById(id)
               .orElseThrow(() -> new RuntimeException("Telefone não encontrado"));

        alterarTelefone(telefoneEndontrado, telefone);
        return repository.save(telefoneEndontrado);
    }

    private void alterarTelefone(Telefone telefoneEndontrado, Telefone telefone) {
        telefoneEndontrado.setNumero(telefone.getNumero());
    }

    public void deletar(Long id){
        var telefoneEndontrado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Telefone não encontrado"));
        repository.delete(telefoneEndontrado);
    }
}
