package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Servico;
import com.diegodev.agendamento.repositories.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository repository;

    public Servico criarServico(Servico servico){
        return repository.save(servico);
    }

    public Servico obterPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public List<Servico> obterServico(){
        return repository.findAll();
    }

    public Servico atualizar(Long id, Servico servico){
        var servicoEncontrado = obterPorId(id);
        atualizarServico(servicoEncontrado, servico);

        return servicoEncontrado;
    }

    private void atualizarServico(Servico servicoEncontrado, Servico servico) {
        if(servico.getNomeServico() != null) servicoEncontrado.setNomeServico(servico.getNomeServico());
        if(servico.getTempo() != null) servicoEncontrado.setTempo(servico.getTempo());
        if(servico.getPrecoBase() != null) servicoEncontrado.setPrecoBase(servico.getPrecoBase());
        if(servico.getStatusServico() != null) servicoEncontrado.setStatusServico(servico.getStatusServico());
    }

    public void deletar(Long id){
        repository.delete(obterPorId(id));
    }
}
