package az.prompt.promptpsycology.mapper;

import az.prompt.promptpsycology.dto.ArticleDataDto;
import az.prompt.promptpsycology.dto.ArticleMetadataDto;
import az.prompt.promptpsycology.jpa.entity.ArticleMetadataJpa;
import az.prompt.promptpsycology.mongo.entity.ArticleData;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper {
    ArticleMetadataJpa toJpaMetadata(ArticleMetadataDto articleMetadataDto);
    ArticleMetadataDto fromJpaMetadata(ArticleMetadataJpa articleMetadataEntity);

    ArticleData toData(ArticleDataDto articleDataDto);
    ArticleDataDto fromData(ArticleData articleData);
}
