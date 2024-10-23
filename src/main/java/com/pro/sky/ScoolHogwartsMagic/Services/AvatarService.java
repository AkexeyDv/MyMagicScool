package com.pro.sky.ScoolHogwartsMagic.Services;

import com.pro.sky.ScoolHogwartsMagic.Exception.FileException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
public class AvatarService {
    private final AvatarService avatarService;

    public AvatarService(AvatarService avatarService) {
        this.avatarService = avatarService;
    }
    public String uploadAvatar(Long idStudent, MultipartFile file) throws FileException {
        Path pathFile=Path.of(file.getName());
return pathFile.toString();
    }

}
