package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Dono;
import com.diegodev.agendamento.repositories.DonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonoService {

    private final DonoRepository repository;

    public void salvar(Dono dono){
        repository.save(dono);
    }
}
