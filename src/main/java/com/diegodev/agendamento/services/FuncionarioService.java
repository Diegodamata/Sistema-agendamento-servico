package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Funcionario;
import com.diegodev.agendamento.repositories.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public void salvar(Funcionario funcionario){
        repository.save(funcionario);
    }
}
