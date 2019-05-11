import model.Person;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        DAOPerson daoPerson = new DAOPerson();

        Person person1 = new Person("John", "Williams", 3000);
        Person person2 = new Person("Mark", "Johnson", 3200);
        Person person3 = new Person("Adam", "Wilson", 3100);

        daoPerson.insertPerson(person1);
        daoPerson.insertPerson(person2);
        daoPerson.insertPerson(person3);

        person2.setFirstName("Tom");
        person2.setLastName("Higgins");
        person2.setSalary(3500);
        daoPerson.updatePerson(person2);

        System.out.println("Person id 1: " + daoPerson.getPersonById(1L));
        List<Person> personList = daoPerson.getAllPersons();
        personList.stream().forEach(person -> System.out.println(person));

        daoPerson.deletePerson(2L);
    }
}
