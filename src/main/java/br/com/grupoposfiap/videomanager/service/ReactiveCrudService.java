package br.com.grupoposfiap.videomanager.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.grupoposfiap.videomanager.domain.BaseEntity;
import br.com.grupoposfiap.videomanager.exceptions.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public abstract class ReactiveCrudService<T extends BaseEntity<T>, R extends ReactiveMongoRepository<T, String>> {

    @Getter
    protected final R repo;

    public Mono<T> create(T entity) {
        return repo.save(entity);
    }

    public Mono<Void> delete(String id) {
        return repo.deleteById(id).then();
    }

    public Flux<T> findAll(Pageable pageable) {
        return repo.findAll();
    }

    public Mono<T> update(String id, T toUpdate) {
        return repo.findById(id)
                .flatMap(outdated -> {
                    var updated = outdated.update(toUpdate);
                    return repo.save(updated);
                })
                .switchIfEmpty(Mono.error(EntityNotFoundException::new));
    }
}
