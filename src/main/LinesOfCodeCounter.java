package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class SemicolonCounter {

    public long countSemicolons(List<File> files) {
        return files.stream()
                .map(countSemicolonsInFile)
                .reduce(0L, Long::sum);
    }

    private final Function<File, Long> countSemicolonsInFile = file -> {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            return fileReader.lines()
                    .filter(line -> line.endsWith(";"))
                    .count();
        } catch (IOException e) {
            return 0L;
        }
    };

}
