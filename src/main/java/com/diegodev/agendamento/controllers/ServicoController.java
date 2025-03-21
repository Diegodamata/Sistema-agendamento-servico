package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.servico.requests.ServicoRequestDTO;
import com.diegodev.agendamento.controllers.dto.servico.responses.ServicoResponseDTO;
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
    public ResponseEntity<Void> criarServico(@RequestBody ServicoRequestDTO dto){

        Servico servicoCriado = servicoService.criarServico(
                servicoMapper.dtoParaServico(dto), dto.tipoServico());

        URI uri = gerarHeaderLocation(servicoCriado.getId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> obterPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(servicoMapper.servicoParaResponseDTO(servicoService.obterPorId(id)));
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> obterServico(){
        List<Servico> servicos = servicoService.obterServico();
        return ResponseEntity.ok(servicos.stream()
                        .map(servicoMapper::servicoParaResponseDTO)
                        .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody ServicoRequestDTO dto){
        return ResponseEntity.ok(servicoMapper
                .servicoParaResponseDTO(servicoService
                        .atualizar(id, servicoMapper.dtoParaServico(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        servicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
