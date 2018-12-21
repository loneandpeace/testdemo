package com.learn.spdemo.controller;

import com.learn.spdemo.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class TestExcleController {

    @Autowired
    IFileService fileService;

    @PostMapping(value = "/fileupload")
    @ResponseBody
    public String ExcleFileReciver(@RequestParam("fileNm") MultipartFile file){
        File f = new File("C:\\Users\\lonea\\Desktop\\test-"+file.getOriginalFilename());
        try {
            if (!f.exists()){
                f.createNewFile();
            }
            file.transferTo(f);
            if(f.getName().toLowerCase().endsWith("xlsx")){
                fileService.getExcleValue(f.getPath());
            } else {
                return "{\"result\": \"error\"}";
            }

            return "{\"result\": \"success\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"result\": \"error\"}";
        }

    }

    @GetMapping(value = "/file")
    public String FileReciver(){
        return "file";
    }


}
