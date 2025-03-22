package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.funcionario.requests.FuncionarioRequestDTO;
import com.diegodev.agendamento.models.Funcionario;
import com.diegodev.agendamento.services.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController implements GenericController{

    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Void> salvarFuncionario(@RequestParam String token, @RequestBody FuncionarioRequestDTO funcDTO){

        Funcionario funcionarioSalvo = funcionarioService
                .salvarFuncionario(token,
                        funcDTO.toFuncionario(),
                        funcDTO.toUsuario(), funcDTO.toTelefones());

        URI uri = gerarHeaderLocation(funcionarioSalvo.getId());

        return ResponseEntity.created(uri).build();
    }
}
