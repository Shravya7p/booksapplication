package com.jpa.book.booksapplication.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper{

    // public final String UPLOAD_DIR="C:\\Users\\pulis\\learningDev\\SpringBootProjects\\booksapplication\\src\\main\\resources\\static\\images";
    public final String UPLOAD_DIR=new ClassPathResource("static/images").getFile().getAbsolutePath();
    boolean f = false;

    public FileUploadHelper() throws IOException{

    }
    public boolean uploadFile(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log it or throw a custom exception
        }
        return f;
    }
    
}
