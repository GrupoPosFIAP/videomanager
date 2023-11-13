package br.com.grupoposfiap.videomanager.mapper;

import org.mapstruct.Mapper;

import br.com.grupoposfiap.videomanager.domain.Video;
import br.com.grupoposfiap.videomanager.dto.VideoDto;

@Mapper(componentModel = "spring")
public interface VideoMapper extends BaseMapper<Video, VideoDto> {

}
