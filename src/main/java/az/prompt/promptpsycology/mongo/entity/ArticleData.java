package az.prompt.promptpsycology.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document(collection = "article")
public class ArticleData {
    @MongoId(targetType = FieldType.STRING)
    private String id;
    private String content;
    private String imageId;
    private String mongoId;
}
