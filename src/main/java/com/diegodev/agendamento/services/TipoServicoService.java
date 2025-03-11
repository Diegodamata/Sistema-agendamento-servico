package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.TipoServico;
import com.diegodev.agendamento.repositories.TipoServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoServicoService {

    private final TipoServicoRepository repository;

    public TipoServico criarTipoServico(TipoServico tipoServico){
        return repository.save(tipoServico);
    }

    public List<TipoServico> obterTipoServico(){
        return repository.findAll();
    }

    public TipoServico obterPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de serviço não encontrado"));
    }

    public TipoServico atualizar(Long id, TipoServico tipoServico){
        TipoServico tipoServicoEncontrado = obterPorId(id);
        atualizarTipoServico(tipoServicoEncontrado, tipoServico);
        return repository.save(tipoServicoEncontrado);
    }

    private void atualizarTipoServico(TipoServico tipoServicoEncontrado, TipoServico tipoServico) {
        if(tipoServico.getTipoServico() != null) tipoServicoEncontrado.setTipoServico(tipoServico.getTipoServico());
    }

    public void deletar(Long id){
        TipoServico tipoServicoEncontrado = obterPorId(id);
        repository.delete(tipoServicoEncontrado);
    }

    public TipoServico findByTipoServico(String tipoServico){
        return repository.findByTipoServico(tipoServico);
    }
}
