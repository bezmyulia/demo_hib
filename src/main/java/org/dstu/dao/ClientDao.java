package org.dstu.dao;

import org.dstu.domain.Client;
import org.dstu.domain.Trip;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDao extends BaseDaoImpl<Client, Integer> {
    public ClientDao() {
        super(Client.class);
    }

    public List<Client> getclientCity(String clientCity) {
        Query q = getSession().createQuery("FROM Trip WHERE (FROM Client WHERE Client.lastName) = \"" + clientCity + "\"");
        return q.list();
    }
}
