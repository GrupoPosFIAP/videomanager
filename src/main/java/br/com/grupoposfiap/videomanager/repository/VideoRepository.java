package br.com.grupoposfiap.videomanager.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.grupoposfiap.videomanager.domain.Video;
import br.com.grupoposfiap.videomanager.enums.Category;
import reactor.core.publisher.Flux;

/**
 * VideoRepository
 */
public interface VideoRepository extends ReactiveMongoRepository<Video, String> {
    Flux<Video> findByCategoriesIn(Flux<Category> categories);

    Flux<Video> findAllByOrderByPublishDate(Pageable page);
}