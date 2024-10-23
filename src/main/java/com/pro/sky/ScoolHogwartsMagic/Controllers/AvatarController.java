package com.pro.sky.ScoolHogwartsMagic.Controllers;

import com.pro.sky.ScoolHogwartsMagic.Exception.FileException;
import com.pro.sky.ScoolHogwartsMagic.Services.AvatarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/avatar")
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }
    @GetMapping
    public String pathFile(MultipartFile file) throws FileException {
        return avatarService.uploadAvatar(25l,file);
    }
}
