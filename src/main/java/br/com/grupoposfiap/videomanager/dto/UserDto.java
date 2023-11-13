package br.com.grupoposfiap.videomanager.dto;

import java.util.List;
public record UserDto(
    String id,
    String name,
    String email,
    List<VideoDto> favorites
) {}
