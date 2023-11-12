package br.com.grupoposfiap.videomanager.service;

import static java.util.stream.Collectors.toList;

import org.springframework.stereotype.Service;

import br.com.grupoposfiap.videomanager.domain.Video;
import br.com.grupoposfiap.videomanager.enums.Category;
import br.com.grupoposfiap.videomanager.exceptions.EntityNotFoundException;
import br.com.grupoposfiap.videomanager.repository.UserRepository;
import br.com.grupoposfiap.videomanager.repository.VideoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VideoService extends ReactiveCrudService<Video, VideoRepository> {

    private final UserRepository users;

    public VideoService(UserRepository users, VideoRepository videos) {
        super(videos);
        this.users = users;
    }

    public Flux<Video> recommendations(String id) {

        var user = users
                .findById(id)
                .switchIfEmpty(Mono.error(EntityNotFoundException::new));

        Flux<Category> categories = user
                .map(u -> {
                    var favs = u.getFavorites();
                    return favs
                            .stream()
                            .flatMap(vid -> vid.getCategories().stream())
                            .distinct()
                            .collect(toList());
                })
                .flatMapMany(Flux::fromIterable);

        return repo.findByCategoriesIn(categories);
    }

    public void favoriteVideo(String userId, String videoId) {
        var user = users
                .findById(userId)
                .switchIfEmpty(Mono.error(EntityNotFoundException::new));

        var video = repo
                .findById(videoId)
                .switchIfEmpty(Mono.error(EntityNotFoundException::new));

        user = user.map(u -> {
            u.getFavorites().add(video.block());
            return u;
        });

        user.subscribe(users::save);
    }
}
