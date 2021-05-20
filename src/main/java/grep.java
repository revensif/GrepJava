import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class grep {

    public static boolean check(String line, String word) {
        String[] words = line.split(" ");
        for (String i : words) {
            if (i.equals(word))
                return true;
        }
        return false;
    }

    public static boolean checkI(String line, String word) {
        String[] words = line.split(" ");
        for (String i : words) {
            if (i.equalsIgnoreCase(word))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        boolean flagR = false, flagV = false, flagI = false;
        if (args.length == 0) System.out.println("В консоли нет аргументов");
        for (String words : args) {
            switch (words) {
                case "[-r]" -> flagR = true;
                case "[-v]" -> flagV = true;
                case "[-i]" -> flagI = true;
            }
        }
        String inputName = args[args.length - 1];
        String word = args[args.length - 2];
        BufferedReader reader = new BufferedReader(new FileReader(inputName));
        try {
            reader = new BufferedReader(new FileReader(inputName));
        } catch (IOException e) {
            System.out.println("Данного файла не существует");
        }
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (flagR) {
                    if (flagV) {
                        if (flagI) {
                            if (!line.matches("(.*)(?i)" + word + "(.*)"))
                                System.out.println(line);
                        } else {
                            if (!line.matches("(.*)" + word + "(.*)"))
                                System.out.println(line);
                        }
                    } else {
                        if (flagI) {
                            if (line.matches("(.*)(?i)" + word + "(.*)"))
                                System.out.println(line);
                        } else {
                            if (line.matches("(.*)" + word + "(.*)"))
                                System.out.println(line);
                        }
                    }
                } else {
                    if (flagV) {
                        if (flagI) {
                            if (!grep.checkI(line, word))
                                System.out.println(line);
                        } else {
                            if (!grep.check(line, word))
                                System.out.println(line);
                        }
                    } else {
                        if (flagI) {
                            if (grep.checkI(line, word))
                                System.out.println(line);
                        } else {
                            if (grep.check(line, word))
                                System.out.println(line);
                        }
                    }
                }
            }
        } catch (
                IOException e) {
        }
    }
}

