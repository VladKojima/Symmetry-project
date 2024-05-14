package team.symmetry.ResumeBack.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class FileSystemStorageService implements FileService {

    @Value("${app.filesPath}")
    private String dir;

    private Path rootLocation;

    @Override
    @PostConstruct
    public void init() {
        try {
            rootLocation = Paths.get(dir);
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public String store(MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        name = name.substring(name.lastIndexOf("."), name.length());
        String filename = UUID.randomUUID().toString() + name;

        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file " + filename);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, rootLocation.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
        }

        return filename;
    }

    @Override
    public String store(String oldname, byte[] bytes) {

        String filename = UUID.randomUUID().toString() + oldname.substring(oldname.lastIndexOf("."), oldname.length());

        File file = rootLocation.resolve(filename).toFile();

        try (OutputStream out = new FileOutputStream(file)) {
            out.write(bytes);
        } catch (IOException e) {
            System.out.println(e);
        }

        return filename;
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            return null;
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                System.out.println(
                        "Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            System.out.println(e);
            return null;
        }
        return null;
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void delete(String filename) {
        File file = rootLocation.resolve(filename).toFile();

        file.delete();
    }
}