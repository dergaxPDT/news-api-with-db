package com.pdt.newsapiwithdb.mapper;

import com.pdt.newsapiwithdb.model.dto.ArticlesDTO;
import com.pdt.newsapiwithdb.model.entity.Articles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticlesMapper {
    ArticlesMapper MAPPER = Mappers.getMapper( ArticlesMapper.class );

    @Mapping(target = "source.id", ignore = true)
    Articles toEntity(ArticlesDTO dto);

    @Mapping(target = "source.id", ignore = true)
    ArticlesDTO toDto(Articles articles);
}
