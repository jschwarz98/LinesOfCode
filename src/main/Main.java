package main;

import java.io.File;
import java.util.List;

public class Main {
    // "E:\\projects\\java\\NeuralNetworkVisuals\\src"
    private static final String filePath = "E:\\projects\\java\\WorldListFilter\\src\\main";

    public static void main(String[] args) {
        List<File> files = new DirectoryTraverser().filesInDirectoryAndSubdirectories(filePath);
        long amount = new LinesOfCodeCounter().countLinesOfCode(files);
        System.out.println("In '" + filePath + "' gibt es ungefähr " + amount + " Zeilen an Code");
    }

}
