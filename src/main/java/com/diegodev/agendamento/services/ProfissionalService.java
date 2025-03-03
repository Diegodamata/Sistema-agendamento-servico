package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.ProfissionalInfo;
import com.diegodev.agendamento.repositories.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository repository;

    public ProfissionalInfo criarProfissional(ProfissionalInfo profissional){
        return repository.save(profissional);
    }
}
