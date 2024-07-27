package az.prompt.promptpsycology.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Component
public class ImageUtils {

    public String convertImageFileToBase64(MultipartFile imageFile) throws IOException {
        byte[] fileContent = imageFile.getBytes();
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public String convertImageBytesToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
