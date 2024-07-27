package az.prompt.promptpsycology.controller;

import az.prompt.promptpsycology.dto.payload.request.ArticleRequest;
import az.prompt.promptpsycology.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ArticleController", description = "API for managing articles")
@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @Operation(summary = "Get all articles metadata")
    @GetMapping
    public ResponseEntity<?> getArticlesMetadata() {
        return ResponseEntity.ok(articleService.getArticlesMetadata());
    }

    @Operation(summary = "Get article by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getArticle(id));
    }

    @Operation(summary = "Add a new article")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addArticle(@ModelAttribute ArticleRequest articleDto) {
        articleService.saveArticle(articleDto);
        return ResponseEntity.ok("Article added successfully");
    }
}
