package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.cliente.requests.ClienteRequestDTO;
import com.diegodev.agendamento.models.Cliente;
import com.diegodev.agendamento.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController implements GenericController { //interface generica para gerar URI

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> salvarCliente(@RequestBody ClienteRequestDTO dto){

        Cliente clienteSalvo = clienteService.salvarCliente(dto.toUsuario(), dto.toTelefones(), dto.toEndereco());

        URI uri = gerarHeaderLocation(clienteSalvo.getId());

        return ResponseEntity.created(uri).build();
    }

//    @GetMapping
//    public ResponseEntity<Page<Usuario>> obterUsuario(
//        @RequestParam(value = "nome", required = false) String nome,
//        @RequestParam(defaultValue = "0") int pagina,
//        @RequestParam(defaultValue = "10") int tamanho
//    ){
//        Page<Usuario> usuariosPage = usuarioService.obterUsuario(nome, pagina, tamanho);
//        return ResponseEntity.ok(usuariosPage);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UsuarioResponseDTO> obterPorId(@PathVariable("id") Long id){
//        return ResponseEntity.ok(usuarioMapper.usuarioParaResponseDTO(usuarioService.obterPorId(id)));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UsuarioResponseDTO> alterar (@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO dto){
//        return ResponseEntity.ok(
//                usuarioMapper.usuarioParaResponseDTO(
//                        usuarioService.atualizar(id, usuarioMapper.dtoRequestParaUsuario(dto))));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id){
//        usuarioService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }
}
