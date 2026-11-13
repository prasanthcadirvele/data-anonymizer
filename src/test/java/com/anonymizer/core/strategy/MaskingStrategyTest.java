package com.anonymizer.core.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaskingStrategyTest {

    @Test
    public void testAnonymizeNormalString() {
        AnonymizationStrategy strategy = new MaskingStrategy();
        String result = strategy.anonymize("Dupont");
        // On s'attend à ce que "Dupont" devienne "****nt" (tous masqués sauf les 2 derniers)
        assertEquals("****nt", result);
    }

    @Test
    public void testAnonymizeShortString() {
        AnonymizationStrategy strategy = new MaskingStrategy();
        String result = strategy.anonymize("AB");
        // Si la chaîne est trop courte (<= 2 caractères), elle est entièrement masquée par "**"
        assertEquals("**", result);
    }

    @Test
    public void testAnonymizeNullOrEmpty() {
        AnonymizationStrategy strategy = new MaskingStrategy();
        assertNull(strategy.anonymize(null));
        assertEquals("", strategy.anonymize(""));
    }
}