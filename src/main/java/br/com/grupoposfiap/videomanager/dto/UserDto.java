package br.com.grupoposfiap.videomanager.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto{

    private String id;
    private String name;
    private String email;
    private List<VideoDto> favorites;
}
