package com.thomasmelchers.processor;



import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ExcelDataCollector {

    private static final Logger LOGGER = Logger.getLogger(ExcelDataCollector.class.getName());

    private Map<String, String> dataCollector;

    public ExcelDataCollector () {
        this.dataCollector = new LinkedHashMap<>();
    }

    public Map<String, String> getDataCollector() {
        return dataCollector;
    }

    public void setDataCollector(Map<String, String> dataCollector) {
        this.dataCollector = dataCollector;
    }

    public void addKeyValuePairData(String key, String value) {
        dataCollector.put(key, value);
    }

    @Override
    public String toString() {
        return "ExcelDataCollector{" +
                "dataCollector=" + dataCollector +
                '}';
    }
}
