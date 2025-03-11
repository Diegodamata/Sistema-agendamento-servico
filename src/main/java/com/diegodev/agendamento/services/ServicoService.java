package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Servico;
import com.diegodev.agendamento.models.TipoServico;
import com.diegodev.agendamento.repositories.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository repository;
    private final TipoServicoService tipoServicoService;

    public Servico criarServico(final Servico servico, final List<String> nomeTipoServico){
        List<TipoServico> listTipoServicos = new ArrayList<>();
        for (String nome : nomeTipoServico){
            TipoServico tipo = tipoServicoService.findByTipoServico(nome);
            if (tipo != null){
                listTipoServicos.add(tipo);
            }
        }
        servico.getTipoServicos().addAll(listTipoServicos);
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
        return repository.save(servicoEncontrado);
    }

    private void atualizarServico(Servico servicoEncontrado, Servico servico) {
        if(servico.getNomeServico() != null) servicoEncontrado.setNomeServico(servico.getNomeServico());
        if(servico.getTempo() != null) servicoEncontrado.setTempo(servico.getTempo());
        if(servico.getPrecoBase() != null) servicoEncontrado.setPrecoBase(servico.getPrecoBase());
    }

    public void deletar(Long id){
        repository.delete(obterPorId(id));
    }
}
