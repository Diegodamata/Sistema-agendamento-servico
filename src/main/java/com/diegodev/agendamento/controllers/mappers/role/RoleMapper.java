package com.diegodev.agendamento.controllers.mappers.role;

import com.diegodev.agendamento.controllers.dto.role.requests.RoleRequestDTO;
import com.diegodev.agendamento.controllers.dto.role.responses.RoleResponseDTO;
import com.diegodev.agendamento.models.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role dtoParaRole(RoleRequestDTO dto);

    List<RoleResponseDTO> listRoleParaListResponse(List<Role> roles);

    RoleResponseDTO roleParaResponse(Role role);

    List<Role> listRequestParaListRole(List<RoleRequestDTO> dtos);
}
