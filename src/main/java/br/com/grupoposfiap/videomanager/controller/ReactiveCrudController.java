package br.com.grupoposfiap.videomanager.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.grupoposfiap.videomanager.domain.BaseEntity;
import br.com.grupoposfiap.videomanager.mapper.BaseMapper;
import br.com.grupoposfiap.videomanager.service.ReactiveCrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public abstract class ReactiveCrudController<T, M extends BaseEntity<M>> {

    private final ReactiveCrudService<M> service;
    private final BaseMapper<M, T> mapper;

    @GetMapping
    public Flux<T> findAll(Pageable page) {
        log.info("Retrieving list");
        var list = service.findAll(page);
        return list.map(mapper::toDto);
    }

    @PostMapping
    public Mono<T> create(@RequestBody T dto) {
        log.info("saving data {}", dto);
        var model = mapper.toModel(dto);
        return service
                .create(model)
                .map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        log.info("deleting data {}", id);
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public Mono<T> update(@PathVariable("id") String id, @RequestBody T dto) {
        var model = mapper.toModel(dto);
        log.info("Updating data {}", id);
        return service
                .update(id, model)
                .map(mapper::toDto);
    }
}
