package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.controllers.dto.agendamento.requests.AgendamentoRequestDTO;
import com.diegodev.agendamento.controllers.mappers.AgendamentoMapper;
import com.diegodev.agendamento.models.Agendamento;
import com.diegodev.agendamento.models.AgendamentoServico;
import com.diegodev.agendamento.models.Usuario;
import com.diegodev.agendamento.services.AgendamentoService;
import com.diegodev.agendamento.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController implements GenericController{

    private final AgendamentoService agendamentoService;
    private final AgendamentoMapper agendamentoMapper;
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> criarAgendamento(@RequestBody AgendamentoRequestDTO dto){

        Usuario usuario = usuarioService.obterPorId(dto.usuarioId());

        Agendamento agendamento = Agendamento.builder().dataAgendamento(dto.dataAgendamento()).usuario(usuario).build();

        List<AgendamentoServico> agendamentoServicos = agendamentoMapper.dtoParaAgendamentoServico(dto.servicos());

        Agendamento agendamentoCriado = agendamentoService.criarAgendamento(agendamento, agendamentoServicos);

        URI uri = gerarHeaderLocation(agendamentoCriado.getId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> obterAgendamentos(){
        return ResponseEntity.ok(agendamentoService.obterAgendamentos());
    }
}
