import model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DAOPerson {

    private HibernateFactory hibernateFactory;
    private Session session;

    public DAOPerson() {
        hibernateFactory = new HibernateFactory();
    }

    public void insertPerson(Person person) {
        session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void updatePerson(Person person) {
        session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void deletePerson(Long id) {
        session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Person person = session.get(Person.class, id);
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Person getPersonById(Long id){
        session = hibernateFactory.getSessionFactory().openSession();
        Person person = null;
        try {
            person = session.get(Person.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return person;
        }
    }

    public List<Person> getAllPersons(){
        session = hibernateFactory.getSessionFactory().openSession();
        List<Person> personList = new ArrayList<>();
        try {
            personList = session.createNativeQuery("SELECT * FROM person").addEntity(Person.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return personList;
        }


    }


}
