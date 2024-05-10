package org.dstu.dao;

import org.dstu.domain.Trip;

public class TripDao extends BaseDaoImpl<Trip, Integer> {
    public TripDao() {
        super(Trip.class);
    }
}
