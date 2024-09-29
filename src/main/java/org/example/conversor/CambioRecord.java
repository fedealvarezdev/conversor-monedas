package org.example.conversor;

import java.util.Map;

public record CambioRecord(
    String result,
    Map<String, Double> conversion_rates
){}