package com.diegodev.agendamento.services;

import com.diegodev.agendamento.models.Convite;
import com.diegodev.agendamento.models.Dono;
import com.diegodev.agendamento.repositories.ConviteRepository;
import com.diegodev.agendamento.repositories.DonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConviteService {

    private final ConviteRepository repository;
    private final DonoRepository donoRepository;

    public String gerarConvite(Long dono_id){
        Dono dono = donoRepository.findById(dono_id)
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

    public List<Convite> obterConvites(Long dono_id) {
        Dono dono = donoRepository.findById(dono_id)
                .orElseThrow(() -> new RuntimeException("Dono não encontrado"));

        return dono.getConvites();
    }

    public void deletar(Long dono_id, Long convite_id) {
        Dono dono = donoRepository.findById(dono_id)
                .orElseThrow(() -> new RuntimeException("Dono não encontrado"));

        repository.delete(dono.getConvites().
                stream()
                .filter(convite -> convite.getId().equals(convite_id))
                .findFirst().get());
    }
}
