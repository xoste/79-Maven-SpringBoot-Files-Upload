package com.xoste.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Leon
 */
@RestController
public class UploadController {
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, String> upload(MultipartFile file, HttpServletRequest req) throws IOException {
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        file.transferTo(new File("D:/" + originalFilename));
        Map<String, String> map = new HashMap<>(1);
        map.put("msg", "ok");
        return map;
    }
}
