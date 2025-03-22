package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Convite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConviteRepository extends JpaRepository<Convite, Long> {

    Optional<Convite> findByToken(String token);

}
