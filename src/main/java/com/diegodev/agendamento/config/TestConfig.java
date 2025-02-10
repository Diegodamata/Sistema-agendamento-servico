package com.diegodev.agendamento.config;

import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.models.enums.StatusUsuario;
import com.diegodev.agendamento.repositories.EnderecoRepository;
import com.diegodev.agendamento.repositories.TelefoneRepository;
import com.diegodev.agendamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void run(String... args) throws Exception {

        var usuario = new Usuario("Diego", "diego@diego.com", "1234", StatusUsuario.CLIENTE);

        usuarioRepository.save(usuario);

        var telefone = new Telefone("123456787");

        var endereco = new Endereco("Clementina", "Francisco Garcia", 765, "Casa", "16250000");

        telefone.setUsuario(usuario);
        endereco.setUsuario(usuario);

        telefoneRepository.save(telefone);
        enderecoRepository.save(endereco);

    }
}
