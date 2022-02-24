package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class LinesOfCodeCounter {

    public long countLinesOfCode(List<File> files) {
        return files.stream()
                .map(countCodeLines)
                .reduce(0L, Long::sum);
    }

    private final Function<File, Long> countCodeLines = file -> {
        long count = 0;
        count += semicolonsInFile(file);
        count += startingPeriods(file);
        return count;
    };

    private long startingPeriods(File file) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                    .map(String::trim)
                    .filter(line -> line.startsWith("."))
                    .count();
        }catch (IOException e) {
            return 0L;
        }
    }

    private long semicolonsInFile(File f) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(f))) {
            return fileReader.lines()
                    .filter(line -> line.endsWith(";"))
                    .count();
        } catch (IOException e) {
            return 0L;
        }
    }


}
