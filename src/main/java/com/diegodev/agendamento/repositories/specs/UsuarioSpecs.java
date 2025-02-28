package com.diegodev.agendamento.repositories.specs;

import com.diegodev.agendamento.models.Usuario;
import org.springframework.data.jpa.domain.Specification;

public class UsuarioSpecs {

    //pesquisa paginada e atraves do nome do usuario
    public static Specification<Usuario> nome(String nome){

        return (root, query, criteriaBuilder) ->
             criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%" + nome.toUpperCase() + "%");

    }
}
