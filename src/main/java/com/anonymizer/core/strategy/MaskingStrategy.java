package com.anonymizer.core.strategy;

public class MaskingStrategy implements AnonymizationStrategy {

    @Override
    public String anonymize(String originalValue) {
        if (originalValue == null || originalValue.isEmpty()) {
            return originalValue;
        }

        int length = originalValue.length();
        if (length <= 2) {
            return "**";
        }

        return "*".repeat(length - 2) + originalValue.substring(length - 2);
    }
}