package org.example1206.dao;

import org.example1206.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL="jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="sql1971";
    private static Connection connection;
    static {
        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//    private List<Person> people;
////it is new
//    {
//        people = new ArrayList<>();
//
//        people.add(new Person(++PEOPLE_COUNT, "Tom",21,"kr1@gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Bob",22,"kr2@gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Mike",23,"kr3@gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Katy",24,"kr4@gmail.com"));
//    }

    public List<Person> index()  {
         List<Person> people = null;
        Statement statement= null;
        try {
            statement = connection.createStatement();
            String SQL="SELECT * FROM person";
          ResultSet resultSet= statement.executeQuery(SQL);
          while(resultSet.next()){
              Person person=new Person();
              person.setId(resultSet.getInt("id"));
              person.setName(resultSet.getString("name"));
              person.setAge(resultSet.getInt("age"));
              person.setEmail(resultSet.getString("email"));
              people.add(person);
          }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return people;
    }

    public Person show(int id) {
//        Person result = null;
//        for (Person idividual : people) {
//
//            if (id == idividual.getId()) {
//                result = idividual;
//            }
//        }
//        return result;
        return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
//        Person toBeUpdatePerson = show(id);
//        toBeUpdatePerson.setName(updatedPerson.getName());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
    }

}
