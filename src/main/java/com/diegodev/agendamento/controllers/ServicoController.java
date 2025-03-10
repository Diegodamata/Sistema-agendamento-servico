package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.servico.ServicoDTO;
import com.diegodev.agendamento.controllers.mappers.servico.ServicoMapper;
import com.diegodev.agendamento.models.Servico;
import com.diegodev.agendamento.services.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController implements GenericController{

    private final ServicoService servicoService;
    private final ServicoMapper servicoMapper;

    @PostMapping
    public ResponseEntity<Void> criarServico(@RequestBody ServicoDTO dto){

        Servico servicoCriado = servicoService.criarServico(servicoMapper.dtoParaServico(dto));

        URI uri = gerarHeaderLocation(servicoCriado.getId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> obterPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(servicoMapper.servicoParaDTO(servicoService.obterPorId(id)));
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> obterServico(){
        List<Servico> servicos = servicoService.obterServico();
        return ResponseEntity.ok(servicos.stream()
                        .map(servicoMapper::servicoParaDTO)
                        .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> atualizar(@PathVariable("id") Long id, @RequestBody ServicoDTO dto){
        return ResponseEntity.ok(servicoMapper
                .servicoParaDTO(servicoService
                        .atualizar(id, servicoMapper.dtoParaServico(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        servicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
