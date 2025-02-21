package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.usuario.requests.CadastroUsuarioDTO;
import com.diegodev.agendamento.controllers.dto.usuario.responses.UsuarioResponseDTO;
import com.diegodev.agendamento.controllers.mappers.UsuarioMapper;
import com.diegodev.agendamento.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody CadastroUsuarioDTO dto){
        var usuarioSalvo = service.criarUsuario(
                mapper.dtoParaUsuario(dto.usuario()),
                mapper.dtoParaPapel(dto.papel()),
                mapper.dtoParaProfissional(dto.profissional()),
                mapper.dtoParaTelefone(dto.telefone()),
                mapper.dtoParaEndereco(dto.endereco()));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(usuarioSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(new UsuarioResponseDTO(usuarioSalvo.getId(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getStatus(),
                usuarioSalvo.getDataCadastro()));
    }

//    @GetMapping
//    public ResponseEntity<List<Usuario>> buscarTodosUsuarios(){
//        return ResponseEntity.ok().body(repository.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id){
//        return ResponseEntity.ok().body(repository.findById(id).orElse(null));
//    }
//
//    @GetMapping("/{id}/agendamentos")
//    public ResponseEntity<List<Agendamento>> buscarAgendamentos(@PathVariable Long id){
//        return repository.findById(id)
//                .map(usuario -> ResponseEntity.ok(usuario.getAgendamentos()))
//                .orElse(null);
//    }
}
