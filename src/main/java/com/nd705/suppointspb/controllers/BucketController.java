package com.nd705.suppointspb.controllers;

import com.nd705.suppointspb.dto.BucketDTO;
import com.nd705.suppointspb.entity.shop.Bucket;
import com.nd705.suppointspb.service.BucketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class BucketController {
    private final BucketService bucketService;

    public BucketController (BucketService bucketService){
        this.bucketService = bucketService;
    }

    @GetMapping("/bucket")
    public String aboutBucket(Model model, Principal principal){
        if(principal == null){
            model.addAttribute("bucket", new BucketDTO());
        }
        else {
            BucketDTO bucketDto = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket", bucketDto);
        }
        return "bucket";
    }
}
