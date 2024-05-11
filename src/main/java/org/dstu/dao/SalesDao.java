package org.dstu.dao;

import org.dstu.domain.Sale;

public class SalesDao extends BaseDaoImpl <Sale, Integer> {
    public SalesDao() {
        super(Sale.class);
    }
}
