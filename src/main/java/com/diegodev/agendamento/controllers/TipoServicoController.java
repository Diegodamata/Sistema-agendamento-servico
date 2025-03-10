package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.models.TipoServico;
import com.diegodev.agendamento.services.TipoServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo-servicos")
@RequiredArgsConstructor
public class TipoServicoController {

    private final TipoServicoService tipoServicoService;

    @PostMapping
    public ResponseEntity<TipoServico> criarTipoServico(@RequestBody TipoServico tipoServico){
        return ResponseEntity.ok(tipoServicoService.criarTipoServico(tipoServico));
    }
}
