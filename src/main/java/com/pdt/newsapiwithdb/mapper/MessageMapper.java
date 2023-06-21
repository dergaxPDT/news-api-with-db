package com.pdt.newsapiwithdb.mapper;

import com.pdt.newsapiwithdb.model.dto.MessageDTO;
import com.pdt.newsapiwithdb.model.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MessageMapper {
    MessageMapper MAPPER = Mappers.getMapper( MessageMapper.class );

    @Mapping(target = "source.id", ignore = true)
    Message toEntity(MessageDTO dto);
}
