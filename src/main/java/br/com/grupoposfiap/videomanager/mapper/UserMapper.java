package br.com.grupoposfiap.videomanager.mapper;

import org.mapstruct.Mapper;

import br.com.grupoposfiap.videomanager.domain.User;
import br.com.grupoposfiap.videomanager.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {

}
