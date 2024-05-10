import org.dstu.dao.ChairDao;
import org.dstu.dao.StudentDao;
import org.dstu.dao.TeacherDao;
import org.dstu.domain.Trip;
import org.dstu.domain.Student;
import org.dstu.domain.Teacher;
import org.dstu.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        StudentDao studentDao = new StudentDao();

        Student student = new Student();
        student.setLastName("Иванов");
        student.setFirstName("Иван");
        student.setMiddleName("Иванович");
        student.setGrp("МИН11");
        student.setTranscriptNum(322223);
        student.setProgramme("ИСТ в научных исследованиях");
        studentDao.save(student);

        ChairDao chairDao = new ChairDao();

        Trip ist = new Trip();
        ist.setNametourr("ИСТ");
        ist.setDatestart(true);
        int savedId = chairDao.save(ist);
        System.out.println(savedId);

        TeacherDao teacherDao = new TeacherDao();
        Teacher teacher = new Teacher();
        teacher.setLastName("Привалов");
        teacher.setFirstName("Максим");
        teacher.setExperience(23);
        teacher.setGrade("ктн");
        teacher.setChair(ist);

        teacherDao.save(teacher);

        Teacher teacher2 = new Teacher();
        teacher2.setLastName("Левченков");
        teacher2.setFirstName("Александр");
        teacher2.setExperience(40);
        teacher2.setGrade("ктн");
        teacher2.setChair(ist);
        teacherDao.save(teacher2);


        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}