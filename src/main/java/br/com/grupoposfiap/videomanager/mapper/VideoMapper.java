package br.com.grupoposfiap.videomanager.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.grupoposfiap.videomanager.domain.Video;
import br.com.grupoposfiap.videomanager.dto.VideoDto;

@Component
public class VideoMapper implements BaseMapper<Video, VideoDto> {

    @Override
    public VideoDto toDto(Video model) {
        return mapper.map(model, VideoDto.class);
    }

    @Override
    public Video toModel(VideoDto dto) {
        var model = mapper.map(dto, Video.class);
        model.setCreatedDate(LocalDateTime.now());
        return model;
    }
    
}
