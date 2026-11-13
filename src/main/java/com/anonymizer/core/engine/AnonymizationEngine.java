package com.anonymizer.core.engine;

import com.anonymizer.core.strategy.AnonymizationStrategy;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Moteur principal pour l'anonymisation de fichiers tabulaires.
 */
public class AnonymizationEngine {

    /**
     * Anonymise une colonne donnée dans un fichier CSV source et génère un fichier de sortie sécurisé.
     */
    public void processCsv(String inputFilePath, String outputFilePath, String targetColumn, AnonymizationStrategy strategy) {

        try (
                Reader reader = new FileReader(inputFilePath);
                Writer writer = new FileWriter(outputFilePath)
        ) {

            CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim();
            org.apache.commons.csv.CSVParser parser = csvFormat.parse(reader);

            List<String> headers = parser.getHeaderNames();

            try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

                csvPrinter.printRecord(headers);

                System.out.println("Début de l'anonymisation de la colonne : " + targetColumn);

                for (CSVRecord record : parser) {
                    List<String> rowValues = new ArrayList<>();

                    for (String header : headers) {
                        String currentValue = record.get(header);

                        if (header.equalsIgnoreCase(targetColumn)) {
                            currentValue = strategy.anonymize(currentValue);
                        }

                        rowValues.add(currentValue);
                    }

                    csvPrinter.printRecord(rowValues);
                }
            }

            System.out.println("Anonymisation terminée avec succès. Fichier généré : " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Erreur lors de l'anonymisation du fichier : " + e.getMessage());
        }
    }
}