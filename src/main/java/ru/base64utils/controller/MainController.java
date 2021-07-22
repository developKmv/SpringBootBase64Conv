package ru.base64utils.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.base64utils.Base64Func;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    public Base64Func func;
    private int i =0;
    private static Logger log = (Logger) LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @PostMapping("/")
    //@ResponseStatus(HttpStatus.OK)
    public String encrypt(@RequestParam("file") MultipartFile file)
    {
        log.debug(String.format("set file: %s",file.toString()));

       try {
            func.encode64m(file,i++);
       } catch (IOException e) {
           e.printStackTrace();
        }
        //System.out.println("param file: " + file);
        //log.debug("Call encrypt");
        //log.debug(String.format("File upload: ",file.toString()));
        //System.out.println(String.format("File upload: ",file.toString()));
        //return "index";
        return "redirect:/";
    }
}
