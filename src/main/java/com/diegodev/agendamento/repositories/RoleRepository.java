package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
