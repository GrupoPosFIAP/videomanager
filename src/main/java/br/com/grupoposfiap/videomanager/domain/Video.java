package br.com.grupoposfiap.videomanager.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import br.com.grupoposfiap.videomanager.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@Getter
@Document
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Video extends BaseEntity<Video> {

    private String title;
    private String description;
    private String uri;
    private LocalDateTime publishDate;
    private long views;
    private long favoriteCount;
    private List<Category> categories;
    @Override
    public Video update(Video toUpdate) {
        
        var title = toUpdate.getTitle();
        if(StringUtils.hasText(title)) {
            this.title = title;
        }

        var description = toUpdate.getDescription();
        if (StringUtils.hasText(description)) {
            this.description = description;
        }

        var uri = toUpdate.getUri();
        if (StringUtils.hasText(uri)) {
            this.uri = uri;
        }

        var publishDate = toUpdate.getPublishDate();
        if (null != publishDate) {
            this.publishDate = publishDate;
        }

        var views = toUpdate.getViews();
        if(views > 0) {
            this.views = views;
        }

        var favCounts = toUpdate.getFavoriteCount();
        if(favCounts > 0) {
            this.favoriteCount = favCounts;
        }

        var categories = toUpdate.getCategories();
        if(null != categories && !categories.isEmpty()) {
            this.categories = categories;
        }

        return this;
    }
}
