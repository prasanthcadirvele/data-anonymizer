package com.anonymizer;

import com.anonymizer.core.engine.AnonymizationEngine;
import com.anonymizer.core.strategy.AnonymizationStrategy;
import com.anonymizer.core.strategy.MaskingStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Démarrage de l'application Data Anonymizer ---");

        String inputFile = "test.csv";
        String outputFile = "output_test.csv";
        String columnToAnonymize = "nom"; // On choisit de masquer la colonne "nom"

        AnonymizationStrategy strategy = new MaskingStrategy();

        AnonymizationEngine engine = new AnonymizationEngine();
        engine.processCsv(inputFile, outputFile, columnToAnonymize, strategy);

        System.out.println("--- Fin du programme ---");
    }
}