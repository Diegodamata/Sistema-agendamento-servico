package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Profissional;
import com.diegodev.agendamento.repositories.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository repository;

    public void salvar(Profissional profissional){
        repository.save(profissional);
    }
}
