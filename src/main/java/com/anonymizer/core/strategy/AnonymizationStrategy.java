package com.anonymizer.core.strategy;

/**
 * Interface commune pour toutes nos stratégies d'anonymisation.
 */
public interface AnonymizationStrategy {

    /**
     * Applique la transformation anonymisante sur une valeur d'origine.
     * @param originalValue La valeur en clair
     * @return La valeur anonymisée
     */
    String anonymize(String originalValue);
}