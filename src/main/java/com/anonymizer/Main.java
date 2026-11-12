package com.anonymizer;

import com.anonymizer.core.CsvParser;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Démarrage du test du CsvParser ---");

        CsvParser parser = new CsvParser();
        parser.readCsvFile("test.csv");

        System.out.println("--- Fin du test ---");
    }
}