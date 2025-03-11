package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Agendamento;
import com.diegodev.agendamento.models.AgendamentoServico;
import com.diegodev.agendamento.models.enums.StatusAgendamento;
import com.diegodev.agendamento.repositories.AgendamentoRepository;
import com.diegodev.agendamento.repositories.AgendamentoServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final AgendamentoServicoRepository agendamentoServicoRepository;
    private final ServicoService servicoService;

    public Agendamento criarAgendamento(Agendamento agendamento, List<AgendamentoServico> servicos){

        agendamento.setStatusAgendamento(StatusAgendamento.CONFIRMADO);
        repository.save(agendamento);
        for(AgendamentoServico as : servicos){

            agendamentoServicoRepository.save(new AgendamentoServico(agendamento, as.getServico(), as.getQuantidade(), as.getPrecoBase()));
        }

        return repository.save(agendamento);
    }

    public List<Agendamento> obterAgendamentos(){
        return repository.findAll();
    }
}
