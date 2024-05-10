package org.dstu.dao;

import org.dstu.domain.Sales;

public class SalesDao extends BaseDaoImpl <Sales, Integer> {
    public SalesDao() {
        super(Sales.class);
    }
}
