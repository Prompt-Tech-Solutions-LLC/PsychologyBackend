package az.prompt.promptpsycology.mongo.repository;


import az.prompt.promptpsycology.mongo.entity.ArticleData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepositoryMongo extends MongoRepository<ArticleData, String> {
}
