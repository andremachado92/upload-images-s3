package com.andremachado92.br.domain.input;
import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageInput {

    private MultipartFile file;
    private String description;

}