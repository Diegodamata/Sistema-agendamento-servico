package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.telefone.TelefoneRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.TelefoneResponseDTO;
import com.diegodev.agendamento.controllers.mappers.telefone.TelefoneMapper;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.services.TelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/telefones")
@RequiredArgsConstructor
public class TelefoneController implements GenericController {

    private final TelefoneService telefoneService;
    private final TelefoneMapper telefoneMapper;

    @PostMapping
    public ResponseEntity<TelefoneResponseDTO> criarTelefone(@RequestBody TelefoneRequestDTO dto){

        Telefone telefoneCriado = telefoneService.criarTelefone(telefoneMapper.dtoParaTelefone(dto));

        URI uri = gerarHeaderLocation(telefoneCriado.getId());

        return ResponseEntity.created(uri).body(telefoneMapper.telefoneParaDTO(telefoneCriado));
    }

    @GetMapping
    public ResponseEntity<List<TelefoneResponseDTO>> obterTelefone(){
        List<Telefone> telefones = telefoneService.obterTelefone();
        return ResponseEntity.ok(telefones.stream()
                .map(telefoneMapper::telefoneParaDTO)
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneResponseDTO> alterar(@PathVariable("id") Long id, @RequestBody TelefoneRequestDTO dto){
        return ResponseEntity.ok( telefoneMapper.telefoneParaDTO(telefoneService.alterar(id, telefoneMapper.dtoParaTelefone(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        telefoneService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
