package com.anonymizer.core;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsable de la lecture sécurisée des fichiers CSV/TXT.
 */
public class CsvParser {

    /**
     * Lit un fichier CSV et affiche ses en-têtes et ses enregistrements.
     * @ chemin du fichier CSV à lire
     */
    public void readCsvFile(String filePath) {
        try (Reader in = new FileReader(filePath)) {

            CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader();

            Iterable<CSVRecord> records = csvFormat.parse(in);
            // On parcourt chaque ligne du fichier
            for (CSVRecord record : records) {
                String recordId = record.get(0);
                System.out.println("Ligne lue - ID / Première colonne : " + recordId);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
    }
}