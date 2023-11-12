package br.com.grupoposfiap.videomanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupoposfiap.videomanager.domain.User;
import br.com.grupoposfiap.videomanager.dto.UserDto;
import br.com.grupoposfiap.videomanager.mapper.UserMapper;
import br.com.grupoposfiap.videomanager.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends ReactiveCrudController<UserDto, User> {

    public UserController(UserService service, UserMapper mapper) {
        super(service, mapper);
    }
}
