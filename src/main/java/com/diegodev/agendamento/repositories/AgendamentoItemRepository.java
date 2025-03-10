package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.AgendamentoItem;
import com.diegodev.agendamento.models.pk.AgendamentoItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoItemRepository extends JpaRepository<AgendamentoItem, AgendamentoItemPK> {
}
