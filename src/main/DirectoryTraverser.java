package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirectoryTraverser {

    public List<File> filesInDirectoryAndSubdirectories(String path) {
        List<File> list = new ArrayList<>();

        try {
            Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(list::add);
        } catch (IOException e) {
            System.out.println("Es kam zum Fehler beim durch gehen der Dateien");
        }
        return list;
    }

}
