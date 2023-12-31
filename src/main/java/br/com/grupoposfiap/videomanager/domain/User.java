package br.com.grupoposfiap.videomanager.domain;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity<User> {

    private String name;

    @Indexed(unique = true)
    private String email;
    private List<Video> favorites;

    @Override
    public User update(User toUpdate) {

        var name = toUpdate.getName();
        if(StringUtils.hasText(name)) {
            this.name = name;
        }

        var email = toUpdate.getEmail();
        if(StringUtils.hasText(email)) {
            this.email = email;
        }

        var favorites = toUpdate.getFavorites();
        if(null != favorites && !favorites.isEmpty()) {
            this.favorites = favorites;
        }

        return this;
    }
}
