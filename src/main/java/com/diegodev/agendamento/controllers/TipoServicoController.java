package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.models.TipoServico;
import com.diegodev.agendamento.services.TipoServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-servicos")
@RequiredArgsConstructor
public class TipoServicoController {

    private final TipoServicoService tipoServicoService;

    @PostMapping
    public ResponseEntity<TipoServico> criarTipoServico(@RequestBody TipoServico tipoServico){
        return ResponseEntity.ok(tipoServicoService.criarTipoServico(tipoServico));
    }

    @GetMapping
    public ResponseEntity<List<TipoServico>> obterTipoServico(){
        return ResponseEntity.ok(tipoServicoService.obterTipoServico());
    }
}
