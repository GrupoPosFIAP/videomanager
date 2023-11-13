package br.com.grupoposfiap.videomanager.mapper;

import br.com.grupoposfiap.videomanager.domain.BaseEntity;

public interface BaseMapper<M extends BaseEntity<M>, D> {

    public D toDto(M model);

    public M toModel(D dto);
}