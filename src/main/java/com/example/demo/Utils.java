package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static String readFile(String relativeFilePath) throws IOException {
        InputStream stream = new ClassPathResource(relativeFilePath).getInputStream();
        return StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
    }

    public static String generateRandomId() {
        return UUID.randomUUID().toString();
    }

    public static Map<String, String> getCsvMap(final String filePath) throws IOException {
        Path classPathResourcePath = Paths.get(new ClassPathResource(filePath).getFile().getAbsolutePath());
        Stream<String> lines = Files.lines(classPathResourcePath);
        Map<String, String> resultMap = lines.map(line -> line.split(","))
                .collect(Collectors.toMap(line -> line[0], line -> line[1]));
        lines.close();
        return resultMap;
    }
}
