package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.models.Convite;
import com.diegodev.agendamento.services.ConviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convites")
@RequiredArgsConstructor
public class ConviteController implements GenericController{

    private final ConviteService conviteService;

    @PostMapping("/{dono_id}")
    public ResponseEntity<String> gerarConvite(@PathVariable("dono_id") Long dono_id){
        String link = conviteService.gerarConvite(dono_id);
        return ResponseEntity.ok(link);
    }

    @GetMapping("/{dono_id}")
    public ResponseEntity<List<Convite>> obterConvites(@PathVariable("dono_id") Long dono_id){
        return ResponseEntity.ok(conviteService.obterConvites(dono_id));
    }

    @DeleteMapping("/{dono_id}/{convite_id}")
    public ResponseEntity<Void> deletar(@PathVariable("dono_id") Long dono_id,
                                              @PathVariable("convite_id") Long convite_id){
        conviteService.deletar(dono_id, convite_id);
        return ResponseEntity.noContent().build();
    }
}
