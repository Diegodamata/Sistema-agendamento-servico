package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Role;
import com.diegodev.agendamento.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role criarRole(Role role){
        return roleRepository.save(role);
    }

    public Role findByRole(String role){
        return roleRepository.findByRole(role);
    }

    public List<Role> obterRoles(){
        return roleRepository.findAll();
    }

    public Role obterPorId(Long id){
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role não encontrado"));
    }

    public Role atualizar(Long id, Role role){
        Role roleEncontrado = obterPorId(id);
        atualizarRole(roleEncontrado, role);
        return roleRepository.save(roleEncontrado);
    }

    private void atualizarRole(Role roleEncontrado, Role role) {
        if(role.getRole() != null) roleEncontrado.setRole(role.getRole());
    }

    public void deletar(Long id){
        Role roleEncontrado = obterPorId(id);
        roleRepository.delete(roleEncontrado);
    }
}
