package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
