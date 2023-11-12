package br.com.grupoposfiap.videomanager.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.grupoposfiap.videomanager.domain.User;
import br.com.grupoposfiap.videomanager.dto.UserDto;

@Component
public class UserMapper implements BaseMapper<User, UserDto> {

    @Override
    public UserDto toDto(User model) {
        return mapper.map(model, UserDto.class);
    }

    @Override
    public User toModel(UserDto dto) {
        var model = mapper.map(dto, User.class);
        model.setCreatedDate(LocalDateTime.now());
        return model;
    }
    
}
