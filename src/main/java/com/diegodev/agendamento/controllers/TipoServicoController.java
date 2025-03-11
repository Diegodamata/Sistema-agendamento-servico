package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.tipoServico.requests.TipoServicoRequestDTO;
import com.diegodev.agendamento.controllers.dto.tipoServico.responses.TipoServicoResponseDTO;
import com.diegodev.agendamento.controllers.mappers.tipoServico.TipoServicoMapper;
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
    private final TipoServicoMapper tipoServicoMapper;

    @PostMapping
    public ResponseEntity<TipoServicoResponseDTO> criarTipoServico(@RequestBody TipoServicoRequestDTO dto){
        return ResponseEntity.ok(
                tipoServicoMapper.tipoServicoParaResponseDTO(
                                tipoServicoService.criarTipoServico(tipoServicoMapper.dtoParaTipoServico(dto))));
    }

    @GetMapping
    public ResponseEntity<List<TipoServicoResponseDTO>> obterTipoServico(){
        return ResponseEntity.ok(
                    tipoServicoMapper.listTipoServicoParaListResponseDTO(tipoServicoService.obterTipoServico()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServicoResponseDTO> obterPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(tipoServicoMapper.tipoServicoParaResponseDTO(tipoServicoService.obterPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoServicoResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody TipoServicoRequestDTO dto){
         return ResponseEntity.ok(
                 tipoServicoMapper.tipoServicoParaResponseDTO(
                         tipoServicoService.atualizar(id,tipoServicoMapper.dtoParaTipoServico(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        tipoServicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
