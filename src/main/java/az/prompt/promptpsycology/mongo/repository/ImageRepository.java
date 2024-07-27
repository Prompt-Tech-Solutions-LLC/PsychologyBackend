package az.prompt.promptpsycology.mongo.repository;


import az.prompt.promptpsycology.mongo.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String>{
}
