package com.diegodev.agendamento.models.enums;

public enum TipoUsuario {
    DONO(1),
    FUNCIONARIO(2),
    CLIENTE(3);

    private final int code;

    TipoUsuario(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
