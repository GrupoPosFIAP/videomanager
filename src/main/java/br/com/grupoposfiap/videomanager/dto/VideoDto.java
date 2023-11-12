package br.com.grupoposfiap.videomanager.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.grupoposfiap.videomanager.enums.Category;
import lombok.Data;

@Data
public class VideoDto {
    private String id;
    private String title;
    private String description;
    private String uri;
    private LocalDateTime publishDate;
    private long views;
    private long favoriteCount;
    private List<Category> categories;
}