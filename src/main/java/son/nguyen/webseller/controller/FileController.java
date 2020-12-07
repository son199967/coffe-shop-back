package son.nguyen.webseller.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        logger.info(String.format("File name '%s' uploaded successfully.", multipartFile.getOriginalFilename()));
        String destination = "/Users/sonnguyen/Desktop/code/web-coffee-font/public/img/" + multipartFile.getOriginalFilename();
        File file = new File(destination);
        multipartFile.transferTo(file);
        return ResponseEntity.ok("../img/"+multipartFile.getOriginalFilename());
    }
}