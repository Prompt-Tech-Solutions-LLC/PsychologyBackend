package az.prompt.promptpsycology.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "image")
@Getter
@Setter
public class Image {
    @MongoId(targetType = FieldType.STRING)
    private String id;
    private byte[] image;
}
