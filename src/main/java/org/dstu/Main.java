package org.dstu;

import org.dstu.dao.ClientDao;
import org.dstu.dao.SalesDao;
import org.dstu.dao.TripDao;
import org.dstu.domain.Client;
import org.dstu.domain.Sales;
import org.dstu.domain.Trip;
import org.dstu.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(final String[] args) {
        Session session = HibernateUtil.getSession();
        try {
            ClientDao clientDao = new ClientDao();

            Client client1 = new Client("Михайлов", "Михаил", "Михайлович", 4444, "89995556611", 20);
            Client client2 = new Client("Олегов", "Олег", "Олегович", 5555, "89995556655", 10);
            Client client3 = new Client("Янов", "Ян", "Янович", 333, "89222334355", 0);


            clientDao.save(client1);
            clientDao.save(client2);
            clientDao.save(client3);

            TripDao tripDao = new TripDao();

            Trip trip1 = new Trip("Тайланд", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 15), "Пхукет", 300);
            Trip trip2 = new Trip("Германия", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 4, 15), "Берлин", 3000);

            tripDao.save(trip1);
            tripDao.save(trip2);

            SalesDao salesDao = new SalesDao();

            Sales sale1 = new Sales("Есенин", "Сергей", "Александрович", "Тайланд", 5, 1, LocalDate.of(2023, 12, 12), trip1, client1);
            Sales sale2 = new Sales("Петров", "Петр", "Петрович", "Германия", 10, 2, LocalDate.of(2024, 1, 10), trip2, client2);
            Sales sale3 = new Sales("Иванов", "Иван", "Иванович", "Германия", 10, 3, LocalDate.of(2024, 1, 10), trip2, client3);


            salesDao.save(sale1);
            salesDao.save(sale2);
            salesDao.save(sale3);

            // Находим всех клиентов по городу тура и выводим в консоль
            List<Client> clientsFromBerlin = clientDao.getClientsByCity("Берлин");
            clientsFromBerlin.forEach(client -> System.out.println(client.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("GOOD");
    }
}