package com.example.locationmonitor;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationMonitor locationMonitor = new LocationMonitor();
        LocationClassifier locationClassifier = new LocationClassifier();
        DataValueEstimator dataValueEstimator = new DataValueEstimator();

        // Start monitoring and classification
        List<Map<String, Object>> loggedData = locationMonitor.getLoggedData();
        List<Map<String, Object>> classifiedData = locationClassifier.classifyData(loggedData);

        // Estimate the value
        double totalValue = dataValueEstimator.estimateTotalValue(classifiedData);

        Log.d("MainActivity", "Total Estimated Value of Data: $" + totalValue);
    }
}
