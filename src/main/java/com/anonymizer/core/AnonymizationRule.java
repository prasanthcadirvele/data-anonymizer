package com.anonymizer.core;

/**
 * Représente une règle d'anonymisation appliquée à une colonne spécifique.
 */
public class AnonymizationRule {
    private String columnName;
    private String strategyType; // e.g., "masking", "hashing", "randomization"

    public AnonymizationRule(String columnName, String strategyType) {
        this.columnName = columnName;
        this.strategyType = strategyType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }
}
