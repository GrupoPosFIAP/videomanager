package br.com.grupoposfiap.videomanager.mapper;

import org.modelmapper.ModelMapper;

import br.com.grupoposfiap.videomanager.domain.BaseEntity;

public interface BaseMapper<M extends BaseEntity<M>, D> {

    final static ModelMapper mapper = new ModelMapper();

    public D toDto(M model);

    public M toModel(D dto);
}