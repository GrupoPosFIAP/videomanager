package br.com.grupoposfiap.videomanager.service;

import org.springframework.stereotype.Service;

import br.com.grupoposfiap.videomanager.domain.User;
import br.com.grupoposfiap.videomanager.repository.UserRepository;

@Service
public class UserService extends ReactiveCrudService<User, UserRepository> {

    public UserService(UserRepository repo) {
        super(repo);
    }
}
