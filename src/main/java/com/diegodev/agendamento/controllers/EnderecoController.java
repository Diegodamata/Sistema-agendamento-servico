package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.endereco.EnderecoRequestDTO;
import com.diegodev.agendamento.controllers.dto.endereco.EnderecoResponseDTO;
import com.diegodev.agendamento.controllers.mappers.endereco.EnderecoMapper;
import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController implements GenericController {

    private final EnderecoService enderecoService;
    private final EnderecoMapper enderecoMapper;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> criarEndereco(@RequestBody EnderecoRequestDTO dto){
        Endereco enderecoCriado = enderecoService.criarEndereco(enderecoMapper.dtoParaEndereco(dto));

        URI uri = gerarHeaderLocation(enderecoCriado.getId());

        return ResponseEntity.created(uri).body(enderecoMapper.enderecoParaDTO(enderecoCriado));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> obterEndereco(){
        List<Endereco> enderecos = enderecoService.obterEndereco();
        return ResponseEntity.ok(enderecos.stream()
                .map(enderecoMapper::enderecoParaDTO)
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> alterar(@PathVariable("id") Long id, @RequestBody EnderecoRequestDTO dto){

        Endereco enderecoAlterar = enderecoService.alterar(id, enderecoMapper.dtoParaEndereco(dto));
        return ResponseEntity.ok(enderecoMapper.enderecoParaDTO(enderecoAlterar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
