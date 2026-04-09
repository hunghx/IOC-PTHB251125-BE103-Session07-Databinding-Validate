package re.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import re.api.service.UploadService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/uploads")
@RequiredArgsConstructor
public class UploadController {
    private final UploadService uploadService;
    // Client -> gửi file -> Server nhận file -> upload vào ổ đĩa / cloud -> trả về đường dẫn truy cập
    // Để nhận file : content-type : form-data (POST, PUT, PATCH)
    // Đối tượng đại diện 1 file trong Java : MultipartFile
    @PostMapping
    public ResponseEntity<String> upload(@RequestParam MultipartFile file) throws IOException {
        // Upleen server
//        String linkFolder= "C:\\Users\\a\\Documents\\uploads";
//        String fileName = UUID.randomUUID()+"_"+file.getOriginalFilename(); // tên file
//        file.transferTo(new File(linkFolder+File.separator+fileName));

        // up lên cloud
        String url = uploadService.uploadFile(file);
        return ResponseEntity.ok().body("Upload thanh công "+ url);

        // Upload nhiều file và trả về 1 danh sách đường dẫn truy cập
    }
}
