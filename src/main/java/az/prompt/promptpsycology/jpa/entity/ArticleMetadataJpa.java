package az.prompt.promptpsycology.jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "article_metadata", schema = "article")
public class ArticleMetadataJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String mongoId;
    private String imageId;

}
