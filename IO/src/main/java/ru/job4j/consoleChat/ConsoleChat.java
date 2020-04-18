package ru.job4j.consoleChat;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {

    private String inputFile;
    private String outputFile;
    private List<String> wordsList;
    private List<String> logList;
    private final Scanner scanner;

    private ConsoleChat(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.scanner = new Scanner(System.in);
        this.generateWords();
        wordsList = new ArrayList<>();
        logList = new ArrayList<>();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(
                new FileReader(System.getProperty("java.io.tmpdir") + this.inputFile))) {
            this.wordsList = br.lines().collect(Collectors.toList());
        } catch (IOException io) {
            io.printStackTrace();
        }
        boolean workChat = true;
        do {
            String inputString;
            String outString;
            try {
                inputString = scanner.nextLine();
                this.logList.add(inputString);
                String end = "end";
                if (end.equals(inputString)) {
                    workChat = false;
                    break;
                }
                String stop = "stop";
                if (stop.equals(inputString)) {
                    workChat = false;
                    continue;
                }
                String continueChat = "continue";
                if (continueChat.equals(inputString)) {
                    workChat = true;
                }
                if (!inputString.isEmpty() && workChat) {
                    outString = this.wordsList.get(new Random().nextInt(this.wordsList.size()));
                    System.out.println(outString);
                    this.logList.add(outString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream(System.getProperty("java.io.tmpdir") + this.outputFile))) {
            for (String s : this.logList) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateWords() {
        String s = "qwertyuiopasdfghjklzxcvbnm!?}{:";
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                (new File(System.getProperty("java.io.tmpdir") + this.inputFile)))) {
            int wordQuantity = 100;
            for (int entry = 1; entry <= wordQuantity; entry++) {
                sb.setLength(0);
                int wordLength = 10;
                for (int i = 0; i < wordLength; i++) {
                    sb.append(s.charAt(new Random().nextInt(s.length())));
                }
                bufferedWriter.write(sb.toString());
                bufferedWriter.write("\n");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("chat.txt", "output.log");
        consoleChat.run();
    }
}
