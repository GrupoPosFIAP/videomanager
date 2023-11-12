package br.com.grupoposfiap.videomanager.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.grupoposfiap.videomanager.domain.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
