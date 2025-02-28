package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.usuario.requests.UsuarioRequestDTO;
import com.diegodev.agendamento.controllers.dto.usuario.responses.UsuarioDetalheDTO;
import com.diegodev.agendamento.controllers.dto.usuario.responses.UsuarioResponseDTO;
import com.diegodev.agendamento.controllers.mappers.usuario.UsuarioMapper;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController implements GenericController { //interface generica para gerar URI

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody UsuarioRequestDTO dto){

        Usuario usuarioCriado = usuarioService.criarUsuario(usuarioMapper.dtoRequestParaUsuario(dto));

        URI uri = gerarHeaderLocation(usuarioCriado.getId());

        return ResponseEntity.created(uri).body(usuarioMapper.usuarioParaResponseDTO(usuarioCriado));
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDetalheDTO>> obterUsuario(
        @RequestParam(value = "nome", required = false) String nome,
        @RequestParam(defaultValue = "0") int pagina,
        @RequestParam(defaultValue = "10") int tamanho
    ){
        Page<Usuario> usuariosPage = usuarioService.obterUsuario(nome, pagina, tamanho);
        return ResponseEntity.ok(usuariosPage.map(usuarioMapper::usuarioParaDetalheDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obterPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioMapper.usuarioParaResponseDTO(usuarioService.obterPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> alterar (@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO dto){
        return ResponseEntity.ok(
                usuarioMapper.usuarioParaResponseDTO(
                        usuarioService.atualizar(
                                id, usuarioMapper.dtoRequestParaUsuario(dto)
                        )));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
