package com.diegodev.agendamento.config;

import com.diegodev.agendamento.models.Agendamento;
import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.repositories.AgendamentoRepository;
import com.diegodev.agendamento.repositories.EnderecoRepository;
import com.diegodev.agendamento.repositories.TelefoneRepository;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public void run(String... args) throws Exception {




        var usuario1 = new Usuario("Diego", "12345678910", "diego@diego.com", "1234", StatusUsuario.CLIENTE);
        var usuario2 = new Usuario("Diego", "12345678910", "diego@diego.com", "1234", StatusUsuario.CLIENTE);

        usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2));

        var agendamento1 = new Agendamento(LocalDateTime.now());
        var agendamento2 = new Agendamento(LocalDateTime.now());
        var agendamento3 = new Agendamento(LocalDateTime.now());

        agendamento1.setUsuario(usuario1);
        agendamento2.setUsuario(usuario2);
        agendamento3.setUsuario(usuario1);

        agendamentoRepository.saveAll(Arrays.asList(agendamento1,agendamento2,agendamento3));

        var telefone = new Telefone("123456787");
        var endereco = new Endereco("Clementina", "Francisco Garcia", 765, "Casa", "16250000");

        telefone.setUsuario(usuario1);
        endereco.setUsuario(usuario1);

        telefoneRepository.save(telefone);
        enderecoRepository.save(endereco);

    }
}
