package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.responses.TelefoneResponseDTO;
import com.diegodev.agendamento.controllers.mappers.telefone.TelefoneMapper;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.services.TelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/telefones")
@RequiredArgsConstructor
public class TelefoneController implements GenericController{

    private final TelefoneService telefoneService;
    private final TelefoneMapper telefoneMapper;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody TelefoneRequestDTO requestDTO){

        Telefone telefoneSalvo = telefoneService.salvar(telefoneMapper.dtoParaTelefone(requestDTO));

        URI uri = gerarHeaderLocation(telefoneSalvo.getId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<TelefoneResponseDTO>> obterTelefones(){
        return ResponseEntity.ok(telefoneMapper
                .listDeTelefoneParaListTelefoneResponse(telefoneService.obterTelefone()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneResponseDTO> obterPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(telefoneMapper.telefoneParaDTO(telefoneService.obterPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody TelefoneRequestDTO requestDTO){
        Telefone telefoneAtualizado = telefoneService.atualizar(id, telefoneMapper.dtoParaTelefone(requestDTO));
        return ResponseEntity.ok(telefoneMapper.telefoneParaDTO(telefoneAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        telefoneService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
