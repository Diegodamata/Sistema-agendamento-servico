package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.services.TelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/telefones")
@RequiredArgsConstructor
public class TelefoneController implements GenericController{

    private final TelefoneService telefoneService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody TelefoneRequestDTO requestDTO){

        Telefone telefoneSalvo = telefoneService.salvar(requestDTO.toTelefone());

        URI uri = gerarHeaderLocation(telefoneSalvo.getId());

        return ResponseEntity.created(uri).build();
    }
//
//    @GetMapping
//    public ResponseEntity<List<TelefoneResponseDTO>> obterTelefones(){
//        return ResponseEntity.ok(telefoneMapper
//                .listDeTelefoneParaListTelefoneResponse(telefoneService.obterTelefone()));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<TelefoneResponseDTO> obterPorId(@PathVariable("id") Long id){
//        return ResponseEntity.ok(telefoneMapper.telefoneParaDTO(telefoneService.obterPorId(id)));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<TelefoneResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody TelefoneRequestDTO requestDTO){
//        Telefone telefoneAtualizado = telefoneService.atualizar(id, telefoneMapper.dtoParaTelefone(requestDTO));
//        return ResponseEntity.ok(telefoneMapper.telefoneParaDTO(telefoneAtualizado));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
//        telefoneService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }
}
