package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.models.Agendamento;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable UUID id){
        return ResponseEntity.ok().body(repository.findById(id).orElse(null));
    }

    @GetMapping("/{id}/agendamentos")
    public ResponseEntity<Set<Agendamento>> buscarAgendamentos(@PathVariable UUID id){
        return repository.findById(id)
                .map(usuario -> ResponseEntity.ok(usuario.getAgendamentos()))
                .orElse(null);
    }
}
