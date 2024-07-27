package az.prompt.promptpsycology.service;

import az.prompt.promptpsycology.dto.payload.request.ArticleRequest;
import az.prompt.promptpsycology.dto.payload.response.ArticleResponse;
import az.prompt.promptpsycology.dto.ArticleMetadataDto;
import az.prompt.promptpsycology.jpa.entity.ArticleMetadataJpa;
import az.prompt.promptpsycology.jpa.repository.ArticleRepositoryJpa;
import az.prompt.promptpsycology.mapper.ArticleMapper;
import az.prompt.promptpsycology.mongo.entity.ArticleData;
import az.prompt.promptpsycology.mongo.repository.ArticleRepositoryMongo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepositoryJpa articleRepositoryJpa;
    private final ArticleRepositoryMongo articleRepositoryMongo;
    private final ArticleMapper articleMapper;
    private final ImageService imageService;

    public void saveArticle(ArticleRequest articleDto) {
        try {
            ArticleData articleData = new ArticleData();

            articleData.setImageId(imageService.saveImage(articleDto.getImageFile()));
            articleData.setContent(articleDto.getContent());

            articleData = articleRepositoryMongo.save(articleData);

            ArticleMetadataJpa articleMetadataEntity = new ArticleMetadataJpa();
            articleMetadataEntity.setTitle(articleDto.getTitle());
            articleMetadataEntity.setImageId(articleData.getImageId());
            articleMetadataEntity.setMongoId(articleData.getMongoId());

            articleRepositoryJpa.save(articleMetadataEntity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ArticleMetadataDto> getArticlesMetadata() {
        return articleRepositoryJpa.findAll().stream()
                .map(articleMapper::fromJpaMetadata)
                .toList();
    }

    public ArticleResponse getArticle(Long id) {
        ArticleMetadataJpa articleMetadataEntity = articleRepositoryJpa.findById(id).orElseThrow();
        ArticleData articleData = articleRepositoryMongo.findById(articleMetadataEntity.getMongoId()).orElseThrow();

        return ArticleResponse.builder()
                .title(articleMetadataEntity.getTitle())
                .content(articleData.getContent())
                .imageId(articleData.getImageId())
                .build();
    }

}
