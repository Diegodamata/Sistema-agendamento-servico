package com.diegodev.agendamento.config;

import com.diegodev.agendamento.models.*;
import com.diegodev.agendamento.models.enums.StatusAgendamento;
import com.diegodev.agendamento.models.enums.StatusServico;
import com.diegodev.agendamento.models.enums.StatusPapel;
import com.diegodev.agendamento.models.enums.StatusUsuario;
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
    private PapelRepository papelRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

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

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Override
    public void run(String... args) throws Exception {


        var usuario1 = Usuario.builder().nome("Diego").cpf("12345678910").email("diego@diego.com").senha("1234").status(StatusUsuario.ATIVO).build();
        var usuario2 = Usuario.builder().nome("Bruno").cpf("12345678910").email("test@test.com").senha("1234").status(StatusUsuario.ATIVO).build();
        var usuario3 = Usuario.builder().nome("Diogo").cpf("12345678910").email("diogo@gmail.com").senha("1234").status(StatusUsuario.ATIVO).build();

        var papel1 = Papel.builder().statusPapel(StatusPapel.CLIENTE).build();
        var papel2 = Papel.builder().statusPapel(StatusPapel.FUNCIONARIO).build();
        var papel3 = Papel.builder().statusPapel(StatusPapel.DONO).build();

        usuario1.getPapeis().add(papel1);
        usuario2.getPapeis().add(papel2);
        usuario3.getPapeis().add(papel3);
        usuario3.getPapeis().add(papel2);

        var pro1 = ProfissionalInfo.builder().usuario(usuario2).nomeEmpresa("Central Atendimento").build();
        var pro2 = ProfissionalInfo.builder().usuario(usuario3).nomeEmpresa("Central Atendimento").build();

        usuario2.setProfissionalInfo(pro1);
        usuario3.setProfissionalInfo(pro2);


        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));

        var av1 = Avaliacao.builder().nota((byte) 3).mensagem("Deveria ser melhor").usuario(usuario1).build();
        var av2 = Avaliacao.builder().nota((byte) 5).mensagem("Muito bom").usuario(usuario1).build();

        avaliacaoRepository.saveAll(Arrays.asList(av1, av2));

        usuario1.getAvaliacoes().add(av1);
        usuario1.getAvaliacoes().add(av2);

        usuarioRepository.save(usuario1);



//
        var telefone = Telefone.builder().numero("123456787").build();
        var endereco = Endereco.builder().cidade("Clementina").rua("Francisco Garcia").numero(765).complemento("Casa").cep("16250000").build();

        telefone.setUsuario(usuario1);
        endereco.setUsuario(usuario1);

        telefoneRepository.save(telefone);
        enderecoRepository.save(endereco);

        var agendamento1 = Agendamento.builder().dataAgendamento(LocalDateTime.now()).statusAgendamento(StatusAgendamento.PENDENTE).build();
        var agendamento2 = Agendamento.builder().dataAgendamento(LocalDateTime.now()).statusAgendamento(StatusAgendamento.CONFIRMADO).build();
        var agendamento3 = Agendamento.builder().dataAgendamento(LocalDateTime.now()).statusAgendamento(StatusAgendamento.CONFIRMADO).build();

        agendamento1.setUsuario(usuario1);
        agendamento2.setUsuario(usuario2);
        agendamento3.setUsuario(usuario1);

        agendamento1.getProfissionais().add(pro2);
        agendamento1.getProfissionais().add(pro1);
        agendamento2.getProfissionais().add(pro2);
        agendamento3.getProfissionais().add(pro2);

        agendamento1.getAvaliacoes().add(av1);
        agendamento1.getAvaliacoes().add(av2);

        agendamentoRepository.saveAll(Arrays.asList(agendamento1, agendamento2, agendamento3));

        av1.setAgendamento(agendamento1);
        av2.setAgendamento(agendamento1);

        avaliacaoRepository.saveAll(Arrays.asList(av1, av2));

        var servico1 = Servico.builder().nomeServico("Ar-condicionado").tempo("2 horas").precoBase(300.0).imgUrl("imagem").statusServico(StatusServico.INSTALACAO).build();
        var servico2 = Servico.builder().nomeServico("Máquina de lavar").tempo("1 horas").precoBase(200.0).imgUrl("imagem").statusServico(StatusServico.MANUTENCAO).build();
        var servico3 = Servico.builder().nomeServico("Portão eletrico").tempo("3 horas").precoBase(600.0).imgUrl("imagem").statusServico(StatusServico.INSTALACAO).build();

        servicoRepository.saveAll(Arrays.asList(servico1, servico2, servico3));

        var agendamentoItem1 = new AgendamentoItem(agendamento1, servico1, 3, 300.0);
        var agendamentoItem2 = new AgendamentoItem(agendamento1, servico2, 3, 200.0);
        var agendamentoItem3 = new AgendamentoItem(agendamento2, servico3, 1, 500.0);
        var agendamentoItem4 = new AgendamentoItem(agendamento3, servico3, 1, 500.0);


        agendamentoItemRepository.saveAll(Arrays.asList(agendamentoItem1, agendamentoItem2, agendamentoItem3, agendamentoItem4));


    }
}
