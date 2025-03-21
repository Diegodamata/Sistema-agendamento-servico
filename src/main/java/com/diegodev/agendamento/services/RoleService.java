package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Role;
import com.diegodev.agendamento.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Role salvar(Role role){
        return repository.save(role);
    }

    public Role finByTipo(String tipo){
        return repository.findByTipo(tipo);
    }

    public List<Role> obterRoles(){
        return repository.findAll();
    }

    public Role obterPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role não existe"));
    }

    public Role atualizar(Long id, Role role){
        Role roleEncontrado = obterPorId(id);

        atualizarRole(roleEncontrado, role);

        return repository.save(roleEncontrado);
    }

    private void atualizarRole(Role roleEncontrado, Role role){
        if(role.getTipo() != null) roleEncontrado.setTipo(role.getTipo());
    }

    public void deletar(Long id){
        repository.delete(obterPorId(id));
    }
}
