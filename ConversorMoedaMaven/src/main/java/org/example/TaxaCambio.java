package org.example;

import java.util.Map;

// Esta classe representa a estrutura da resposta JSON da API
public class TaxaCambio {
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    @Override
    public String toString() {
        return "Taxas de Câmbio: " + conversion_rates;
    }
}