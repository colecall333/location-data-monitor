package com.example.locationmonitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationClassifier {

    public List<Map<String, Object>> classifyData(List<Map<String, Object>> loggedData) {
        for (Map<String, Object> dataPoint : loggedData) {
            String classification = classify(dataPoint);
            dataPoint.put("classification", classification);
        }
        return loggedData;
    }

    private String classify(Map<String, Object> dataPoint) {
        double latitude = (double) dataPoint.get("latitude");
        double longitude = (double) dataPoint.get("longitude");

        // Simulate accuracy for classification (in a real scenario, you'd use actual accuracy)
        double accuracy = 100;  // Assume 100 meters for basic location, lower for precise

        if (accuracy > 50) {
            return "Basic Location";
        } else {
            return "Precise Location";
        }
    }
}

