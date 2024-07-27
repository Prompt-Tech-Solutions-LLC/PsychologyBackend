package az.prompt.promptpsycology.service;

import az.prompt.promptpsycology.exception.NotFoundException;
import az.prompt.promptpsycology.utils.ImageUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final GridFsTemplate gridFsTemplate;
    private final ImageUtils imageUtils;

    public String saveImage(MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("fileName", file.getOriginalFilename());
        metaData.put("contentType", file.getContentType());

        return gridFsTemplate.store(
                file.getInputStream(), file.getOriginalFilename(), file.getContentType(), metaData
        ).toString();
    }

    public String getImage(String id) {
        GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));

        try {
            if (gridFSFile != null) {
                GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
                InputStream inputStream = resource.getInputStream();
                return imageUtils.convertImageBytesToBase64(IOUtils.toByteArray(inputStream));
            }
        } catch (IOException e) {
            throw new NotFoundException("NOT_FOUND","Image not found");
        }
        return "";
    }
}
