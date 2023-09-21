package com.db.nace.controller;


import com.db.nace.dto.NaceDto;
import com.db.nace.service.NaceUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/nace")
public class NaceController {

    @Autowired
    private NaceUploadService naceUploadService;

    @PostMapping("/upload")
    public ResponseEntity uploadNaceData(@RequestParam("file")MultipartFile file) throws IOException {

        naceUploadService.upload(file);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/order/{orderNum}")
    public ResponseEntity<NaceDto> findByOrderNum(@PathVariable String orderNum){
        NaceDto naceDto = naceUploadService.findByOrderNum(orderNum);
        return ResponseEntity.ok(naceDto);
    }

}
