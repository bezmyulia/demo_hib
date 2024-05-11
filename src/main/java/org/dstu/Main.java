package org.dstu;

import org.dstu.dao.ClientDao;
import org.dstu.dao.SalesDao;
import org.dstu.dao.TripDao;
import org.dstu.domain.Client;
import org.dstu.domain.Sale;
import org.dstu.domain.Trip;
import org.dstu.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(final String[] args) {
        Session session = HibernateUtil.getSession();
        try {
            ClientDao clientDao = new ClientDao();

            Client client1 = new Client("Михайлов", "Михаил", "Михайлович", 4444, "89995556611", 10);
            Client client2 = new Client("Олегов", "Олег", "Олегович", 5555, "89995556655", 10);

            clientDao.save(client1);
            clientDao.save(client2);

            TripDao tripDao = new TripDao();

            Trip trip1 = new Trip("Тайланд", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 15), "Пхукет", 300);
            Trip trip2 = new Trip("Германия", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 4, 15), "Берлин", 3000);

            tripDao.save(trip1);
            tripDao.save(trip2);

            SalesDao salesDao = new SalesDao();

            Sale sale1 = new Sale("Есенин", "Сергей", "Александрович", "Тайланд", 5, 1, LocalDate.of(2023, 12, 12), trip1, client1);
            Sale sale2 = new Sale("Есенин", "Сергей", "Александрович", "Германия", 10, 2, LocalDate.of(2024, 1, 10), trip2, client2);

            salesDao.save(sale1);
            salesDao.save(sale2);

            // Находим всех клиентов по городу тура и выводим в консоль
            List<Client> clientsFromBerlin = clientDao.getClientsByCity("Берлин");
            clientsFromBerlin.forEach(client -> System.out.println(client.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("FUCK");
    }
}