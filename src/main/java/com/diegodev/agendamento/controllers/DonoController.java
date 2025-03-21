package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.dono.DonoRequestDTO;
import com.diegodev.agendamento.services.DonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donos")
@RequiredArgsConstructor
public class DonoController {

    private final DonoService donoService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody DonoRequestDTO donoDTO){

        return null;
    }
}
