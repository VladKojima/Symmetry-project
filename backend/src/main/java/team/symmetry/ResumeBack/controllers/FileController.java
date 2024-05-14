package team.symmetry.ResumeBack.controllers;

import java.io.IOException;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import team.symmetry.ResumeBack.utils.FileService;

@RestController
@RequestMapping("/api/file")
@CrossOrigin
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping("/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = fileService.loadAsResource(filename);

        try {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE,
                            Files.probeContentType(fileService.load(filename)))
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
        
        try{
            return ResponseEntity.ok(fileService.store(file));
        }
        catch(IOException e){
            return ResponseEntity.status(500).build();
        }
    }
}
