package com.example.locationmonitor;

import java.util.List;
import java.util.Map;

public class DataValueEstimator {

    public double estimateTotalValue(List<Map<String, Object>> classifiedData) {
        double totalValue = 0;

        for (Map<String, Object> dataPoint : classifiedData) {
            totalValue += estimateAssetValue(dataPoint);
            totalValue += estimateActivityValue(dataPoint);
            totalValue += estimateFutureValue(dataPoint);
        }

        return totalValue;
    }

    private double estimateAssetValue(Map<String, Object> dataPoint) {
        String classification = (String) dataPoint.get("classification");
        double dataSize = (double) dataPoint.get("size_in_bytes");

        switch (classification) {
            case "Basic Location":
                return dataSize * 0.02;  // $0.02 per MB for basic location data
            case "Precise Location":
                return dataSize * 0.10;  // $0.10 per MB for precise location data
            default:
                return 0;
        }
    }

    private double estimateActivityValue(Map<String, Object> dataPoint) {
        // Simulating an arbitrary access frequency value
        return 0.05 * 10;  // $0.05 per access, assuming 10 accesses
    }

    private double estimateFutureValue(Map<String, Object> dataPoint) {
        String classification = (String) dataPoint.get("classification");
        if ("Precise Location".equals(classification)) {
            return estimateAssetValue(dataPoint) * 2;  // Example multiplier for future value
        }
        return 0;
    }
}

