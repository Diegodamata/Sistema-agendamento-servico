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
}
