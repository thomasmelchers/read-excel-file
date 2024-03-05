package com.thomasmelchers.models;

import java.util.ArrayList;
import java.util.List;

public class Sales {

    private List<Sale> salesList;

    public Sales() {
        this.salesList = new ArrayList<>();
    }

    public List<Sale> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sale> salesList) {
        this.salesList = salesList;
    }

    public void addSales(Sale sale) {
        salesList.add(sale);
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesList=" + salesList +
                '}';
    }
}
