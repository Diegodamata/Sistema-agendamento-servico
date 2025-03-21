package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.usuario.requests.UsuarioRequestDTO;
import com.diegodev.agendamento.controllers.dto.usuario.responses.UsuarioResponseDTO;
import com.diegodev.agendamento.controllers.mappers.endereco.EnderecoMapper;
import com.diegodev.agendamento.controllers.mappers.prossifional.ProfissionalMapper;
import com.diegodev.agendamento.controllers.mappers.role.RoleMapper;
import com.diegodev.agendamento.controllers.mappers.telefone.TelefoneMapper;
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
    private final RoleMapper roleMapper;
    private final ProfissionalMapper proMapper;
    private final TelefoneMapper teleMapper;
    private final EnderecoMapper endMapper;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody UsuarioRequestDTO dto){

        Usuario usuarioCridado = usuarioService.salvar(
                dto.toUsuario(),
                roleMapper.listRequestParaListRole(dto.roles()),
                proMapper.dtoParaProfissional(dto.profissional()),
                teleMapper.listDeDToParaListTelefone(dto.telefones()),
                endMapper.listDeDTOParaListDeEndereco(dto.enderecos()));

        URI uri = gerarHeaderLocation(usuarioCridado.getId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> obterUsuario(
        @RequestParam(value = "nome", required = false) String nome,
        @RequestParam(defaultValue = "0") int pagina,
        @RequestParam(defaultValue = "10") int tamanho
    ){
        Page<Usuario> usuariosPage = usuarioService.obterUsuario(nome, pagina, tamanho);
        return ResponseEntity.ok(usuariosPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obterPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioMapper.usuarioParaResponseDTO(usuarioService.obterPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> alterar (@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO dto){
        return ResponseEntity.ok(
                usuarioMapper.usuarioParaResponseDTO(
                        usuarioService.atualizar(id, usuarioMapper.dtoRequestParaUsuario(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
