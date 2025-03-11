package com.diegodev.agendamento.controllers.mappers.role;

import com.diegodev.agendamento.controllers.dto.role.requests.RoleRequestDTO;
import com.diegodev.agendamento.controllers.dto.role.responses.RoleResponseDTO;
import com.diegodev.agendamento.models.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role dtoRequestParaRole(RoleRequestDTO dto);

    RoleResponseDTO roleParaRoleResponse(Role role);

    List<RoleResponseDTO> listRoleParaListRoleResponseDTO(List<Role> role);

}
