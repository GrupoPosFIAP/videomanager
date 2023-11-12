package br.com.grupoposfiap.videomanager.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Statistics {
    private long videosCount;
    private long viewsAverage;
    private long favoritesCount;
}
