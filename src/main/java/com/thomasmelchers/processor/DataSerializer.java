package com.thomasmelchers.processor;



import com.thomasmelchers.models.Sale;
import com.thomasmelchers.models.Sales;

import java.util.List;
import java.util.logging.Logger;


public class DataSerializer {


    private static final Logger LOGGER = Logger.getLogger(DataSerializer.class.getName());
    private final List<ExcelDataCollector> excelDataCollectorList;
    private Sales sales;

    public DataSerializer(DataList dataList) {
        this.excelDataCollectorList = dataList.getExcelDataCollectorList();
        this.sales = new Sales();
    }

    public void serializing() {

        for (ExcelDataCollector edc : excelDataCollectorList){
            Sale sale = new Sale();
            sale.setTeaName(edc.getDataCollector().get("teaName"));
            sale.setTeaOrigin(edc.getDataCollector().get("teaOrigin"));
            sale.setCustomer(edc.getDataCollector().get("customer"));
            sale.setQuantity(Double.parseDouble(edc.getDataCollector().get("quantity")));
            sale.setPrice(Double.parseDouble(edc.getDataCollector().get("price")));
            sale.setTotal(Double.parseDouble(edc.getDataCollector().get("total")));

            sales.addSales(sale);
        }


    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }
}
