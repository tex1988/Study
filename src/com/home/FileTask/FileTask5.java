package com.home.FileTask;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTask5 {
        public static void main(String[] args) throws IOException {
            Path path1 = Paths.get("D:/test/data/firstDir");
            Path path2 = Paths.get("D:/test/data/secondDir/third");
            Path resultPath = getDiffBetweenTwoPaths(path1, path2);
            System.out.println(resultPath);   //expected output '../secondDir/third' or '..\secondDir\third'
        }

        public static Path getDiffBetweenTwoPaths(Path path1, Path path2) {
            if (path1.isAbsolute()) {
                return path1.relativize(path2);
            }
            else return path1;
        }
}
