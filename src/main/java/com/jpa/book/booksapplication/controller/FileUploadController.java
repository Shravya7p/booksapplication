package com.jpa.book.booksapplication.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpa.book.booksapplication.helper.FileUploadHelper;
@RestController
public class FileUploadController {
    @Autowired
    public FileUploadHelper fileUploadHelper;
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());
       
        try{
            //validation
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain the file!!");
            }

                //    if(!file.getContentType().equals("images/jpg")){
                //     System.out.println("Only JPEG|JPG file types are supported!");
                //    }

                boolean f = fileUploadHelper.uploadFile(file);
                if(f){
                    //return ResponseEntity.ok("File is successfully uploaded!");
                    return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       

    


        return ResponseEntity.ok("Working!!");
    }
    // public ResponseEntity<String> uploadFile(){
    //     return ResponseEntity.ok("It's working!!!");
    // }

}
