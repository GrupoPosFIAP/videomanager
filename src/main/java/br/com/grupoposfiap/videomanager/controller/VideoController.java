package br.com.grupoposfiap.videomanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupoposfiap.videomanager.domain.Video;
import br.com.grupoposfiap.videomanager.dto.VideoDto;
import br.com.grupoposfiap.videomanager.mapper.VideoMapper;
import br.com.grupoposfiap.videomanager.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController extends ReactiveCrudController<VideoDto, Video> {

    public VideoController(VideoService service, VideoMapper mapper) {
        super(service, mapper);
    }

    @GetMapping
    public Flux<Video> findAll(@RequestBody Video example, Pageable pageable) {
        log.info("Retrieving list of videos");

        var list = service.findAll(example, pageable);

        return list.map(mapper:toDto);
    }
}
