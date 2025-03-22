package com.diegodev.agendamento.controllers;

import com.diegodev.agendamento.services.ConviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
