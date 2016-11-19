package org.adrianonobre.wordfinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by adriano on 2016-11-18.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            System.exit(-1);
        }

        String fileName = args[0];
        char[] letters = args[1].toCharArray();

        FastWordFinder fastWordFinder = null;
        try {
            fastWordFinder = new FastWordFinder(Files.lines(Paths.get(fileName)).collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println(String.format("Could not open file %s. Is this path correct?", fileName));
            printUsage();
            System.exit(-1);
        }

        final long start = System.currentTimeMillis();
        final Set<String> words = fastWordFinder.findWords(letters);
        final long end = System.currentTimeMillis();

        words.forEach(System.out::println);
        System.out.println(String.format("Found %d words using the letters %s in %d millis", words.size(), Arrays.toString(letters), (end - start)));
    }

    private static void printUsage() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Usage:");
        System.out.println("java -jar wordFinder.jar <word_list_file> <letters>");
        System.out.println("For example:");
        System.out.println("java -jar wordFinder.jar /usr/share/dict/words atrpzeuf");
        System.out.println("-------------------------------------------------------");
    }
}
