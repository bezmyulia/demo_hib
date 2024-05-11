package org.dstu;

import org.dstu.dao.ClientDao;
import org.dstu.domain.Client;
import org.dstu.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class Main {

    public static void main(final String[] args) {
        final Session session = HibernateUtil.getSession();
        ClientDao clientDao = new ClientDao();

        Client client1 = new Client(2, "Михайлов", "Михаил", "Михайлович", 4444, "89995556611", 10);
        Client client2 = new Client(3, "Олегов", "Олег", "Олегович", 5555, "89995556655", 10);

        clientDao.save(client1);
        clientDao.save(client2);

        List<Client> clientsByCity = clientDao.getClientsByCity("Moscow");
        clientsByCity.forEach(client -> System.out.println(client.getId()));

        List<Client> clients = clientDao.findAll();
        clients.forEach(client -> System.out.println(client.getId()));
//        StudentDao studentDao = new StudentDao();
//
//        Student student = new Student();
//        student.setLastName("Иванов");
//        student.setFirstName("Иван");
//        student.setMiddleName("Иванович");
//        student.setGrp("МИН11");
//        student.setTranscriptNum(322223);
//        student.setProgramme("ИСТ в научных исследованиях");
//        studentDao.save(student);
//
//        ChairDao chairDao = new ChairDao();
//
//        Trip ist = new Trip();
//        ist.setNametourr("ИСТ");
//        ist.setDatestart(true);
//        int savedId = chairDao.save(ist);
//        System.out.println(savedId);
//
//        TeacherDao teacherDao = new TeacherDao();
//        Teacher teacher = new Teacher();
//        teacher.setLastName("Привалов");
//        teacher.setFirstName("Максим");
//        teacher.setExperience(23);
//        teacher.setGrade("ктн");
//        teacher.setChair(ist);
//
//        teacherDao.save(teacher);
//
//        Teacher teacher2 = new Teacher();
//        teacher2.setLastName("Левченков");
//        teacher2.setFirstName("Александр");
//        teacher2.setExperience(40);
//        teacher2.setGrade("ктн");
//        teacher2.setChair(ist);
//        teacherDao.save(teacher2);
//
//
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
        System.out.println("FUCK");
    }
}