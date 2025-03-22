package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Convite;
import com.diegodev.agendamento.models.Dono;
import com.diegodev.agendamento.repositories.ConviteRepository;
import com.diegodev.agendamento.repositories.DonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConviteService {

    private final ConviteRepository repository;
    private final DonoRepository donoRepository;

    public String gerarConvite(Long id){
        Dono dono = donoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dono não encontrado"));

        String token = UUID.randomUUID().toString();

        LocalDateTime dataExpiracao = LocalDateTime.now().plusDays(5);

        Convite convite = new Convite();
        convite.setToken(token);
        convite.setDataExpiracao(dataExpiracao);
        convite.setDono(dono);

        repository.save(convite);

        return "http://localhost:8080/funcionarios?token=" + token;
    }
}
