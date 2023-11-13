package br.com.grupoposfiap.videomanager.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.grupoposfiap.videomanager.domain.User;
import br.com.grupoposfiap.videomanager.dto.UserDto;

public class UserMapperTest {

    private UserMapper userMapper;

    private User model;
    private UserDto dto;

    private static final String name = "First Middle Last";
    private static final String email = "name.lastName@hotmail.com";

    @BeforeEach
    void initTests() {
        userMapper = new UserMapperImpl();
        model = User
            .builder()
            .name(name)
            .email(email)
            .build();

        dto = new UserDto(null, name, email, null);
    }

    @Test
    void toModelTest() {
        var actual = userMapper.toModel(dto);
        assertThat(actual).isEqualTo(model);
    }

    @Test
    void toDtoTest() {
        var actual = userMapper.toDto(model);
        assertThat(actual).isEqualTo(dto);
    }
}
