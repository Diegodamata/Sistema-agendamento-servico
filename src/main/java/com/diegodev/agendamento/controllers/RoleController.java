package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.role.requests.RoleRequestDTO;
import com.diegodev.agendamento.controllers.dto.role.responses.RoleResponseDTO;
import com.diegodev.agendamento.controllers.mappers.role.RoleMapper;
import com.diegodev.agendamento.models.Role;
import com.diegodev.agendamento.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController implements GenericController{

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody RoleRequestDTO requestDTO){

        Role roleSalva = roleService.salvar(roleMapper.dtoParaRole(requestDTO));

        URI uri = gerarHeaderLocation(roleSalva.getId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> obterRoles(){
        return ResponseEntity
                .ok(roleMapper.listRoleParaListResponse(roleService.obterRoles()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> obterPorId(@PathVariable("id") Long id){
        return ResponseEntity
                .ok(roleMapper.roleParaResponse(roleService.obterPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody RoleRequestDTO dto){
        Role roleAtualizada = roleService.atualizar(id, roleMapper.dtoParaRole(dto));

        return ResponseEntity.ok(roleMapper.roleParaResponse(roleAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        roleService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
