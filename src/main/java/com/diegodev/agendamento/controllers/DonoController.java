package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.dono.DonoRequestDTO;
import com.diegodev.agendamento.models.Dono;
import com.diegodev.agendamento.services.DonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/donos")
@RequiredArgsConstructor
public class DonoController implements GenericController{

    private final DonoService donoService;

    @PostMapping
    public ResponseEntity<Void> salvarDono(@RequestBody DonoRequestDTO donoDTO){

        Dono donoSalvo = donoService.salvarDono(donoDTO.toDono(), donoDTO.toUsuario(), donoDTO.toTelefones());

        URI uri = gerarHeaderLocation(donoSalvo.getId());

        return ResponseEntity.created(uri).build();
    }
}
