package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {

    TipoServico findByTipoServico(String tipoServico);
}
