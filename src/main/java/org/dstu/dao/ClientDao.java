package org.dstu.dao;

import org.dstu.domain.Client;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDao extends BaseDaoImpl<Client, Integer> {

    public ClientDao() {
        super(Client.class);
    }

    public List<Client> getClientsByCity(String clientCity) {
        String hql = "SELECT c " +
                "FROM Client c " +
                "LEFT JOIN c.sales s " +
                "LEFT JOIN s.trip t " +
                "WHERE t.city = :cityName";

        Query<Client> query = getSession().createQuery(hql, Client.class);
        query.setParameter("cityName", clientCity);
        return query.list();
    }
}
