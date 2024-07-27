package az.prompt.promptpsycology.jpa.repository;

import az.prompt.promptpsycology.jpa.entity.ArticleMetadataJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepositoryJpa extends JpaRepository<ArticleMetadataJpa, Long> {

}
