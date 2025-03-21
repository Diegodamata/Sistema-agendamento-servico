package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.endereco.EnderecoRequestDTO;
import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController implements GenericController{

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody EnderecoRequestDTO requestDTO){
        Endereco enderecoSalvo = enderecoService.salvar(requestDTO.toEndereco());

        URI uri = gerarHeaderLocation(enderecoSalvo.getId());

        return ResponseEntity.created(uri).build();
    }

//    @GetMapping
//    public ResponseEntity<List<EnderecoResponseDTO>> obterEndereco(){
//        return ResponseEntity.ok(
//                enderecoMapper.listEnderecoParaListEnderecoResponse(enderecoService.obterEndereco()));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EnderecoResponseDTO> obterPorId(@PathVariable("id") Long id){
//       return ResponseEntity.ok(
//               enderecoMapper.enderecoParaDTO(enderecoService.obterPorId(id)));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<EnderecoResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody EnderecoRequestDTO requestDTO){
//
//        Endereco enderecoAtualizado = enderecoService.atualizar(id, enderecoMapper.dtoParaEndereco(requestDTO));
//        return ResponseEntity.ok(enderecoMapper.enderecoParaDTO(enderecoAtualizado));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
//        enderecoService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }
}
