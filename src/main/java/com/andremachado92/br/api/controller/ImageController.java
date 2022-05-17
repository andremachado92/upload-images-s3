package com.andremachado92.br.api.controller;
import java.nio.file.Path;
import java.util.UUID;

import com.andremachado92.br.domain.input.ImageInput;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class ImageController {

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateImage(ImageInput imageInput) {

        var fileName = UUID.randomUUID().toString()
                + "_" + imageInput.getFile().getOriginalFilename();

        var imageFile = Path.of("D:\\Documentos\\Api-upload-imagem-arquivos", fileName);

        System.out.println(imageInput.getDescription());
        System.out.println(imageFile);
        System.out.println(imageInput.getFile().getContentType());

        try {
            imageInput.getFile().transferTo(imageFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
