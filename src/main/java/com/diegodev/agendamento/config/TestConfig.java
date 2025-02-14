package com.diegodev.agendamento.config;

import com.diegodev.agendamento.models.*;
import com.diegodev.agendamento.models.enums.StatusAgendamento;
import com.diegodev.agendamento.models.enums.StatusServico;
import com.diegodev.agendamento.models.enums.StatusPapel;
import com.diegodev.agendamento.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AgendamentoItemRepository agendamentoItemRepository;

    @Override
    public void run(String... args) throws Exception {


        var usuario1 = new Usuario("Diego", "12345678910", "diego@diego.com", "1234");
        var usuario2 = new Usuario("Diego", "12345678910", "diego@diego.com", "1234");

        usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2));

        var telefone = new Telefone("123456787");
        var endereco = new Endereco("Clementina", "Francisco Garcia", 765, "Casa", "16250000");

        telefone.setUsuario(usuario1);
        endereco.setUsuario(usuario1);

        telefoneRepository.save(telefone);
        enderecoRepository.save(endereco);

        var agendamento1 = new Agendamento(LocalDateTime.now(), StatusAgendamento.PENDENTE);
        var agendamento2 = new Agendamento(LocalDateTime.now(), StatusAgendamento.CONFIRMADO);
        var agendamento3 = new Agendamento(LocalDateTime.now(), StatusAgendamento.CONFIRMADO);

        agendamento1.setUsuario(usuario1);
        agendamento2.setUsuario(usuario2);
        agendamento3.setUsuario(usuario1);

        agendamentoRepository.saveAll(Arrays.asList(agendamento1,agendamento2,agendamento3));

        var servico1 = new Servico("Ar-condicionado", "2 horas", 300.0, "imagem", StatusServico.INSTALACAO);
        var servico2 = new Servico("Máquina de lavar", "1 horas", 200.0, "imagem", StatusServico.MANUTENCAO);
        var servico3 = new Servico("Portão eletrico", "3 horas", 600.0, "imagem", StatusServico.INSTALACAO);

        servicoRepository.saveAll(Arrays.asList(servico1,servico2,servico3));

        var agendamentoItem1 = new AgendamentoItem(agendamento1, servico1, 3, 300.0);
        var agendamentoItem2 = new AgendamentoItem(agendamento1, servico2, 3, 200.0);
        var agendamentoItem3 = new AgendamentoItem(agendamento2, servico3, 1, 500.0);
        var agendamentoItem4 = new AgendamentoItem(agendamento3, servico3, 1, 500.0);



        agendamentoItemRepository.saveAll(Arrays.asList(agendamentoItem1, agendamentoItem2, agendamentoItem3, agendamentoItem4));



    }
}
