package az.prompt.promptpsycology.controller;

import az.prompt.promptpsycology.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tag(name = "ImageController", description = "API for managing images")
@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Operation(summary = "Get image by ID")
    @GetMapping("/{id}")
    public String getImage(@PathVariable("id") String id) {
        return imageService.getImage(id);
    }

    @Operation(summary = "Upload an image")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.saveImage(file);
    }
}
