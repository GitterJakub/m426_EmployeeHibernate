package ch.bbw.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeApplication {

    public static void main(String[] args) {
        System.out.println("EmployeeApplication starts..");
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
             EntityManager entitymanager = emfactory.createEntityManager();
        System.out.println("EntityManager passed");
        entitymanager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Employee> listEmployees = entitymanager.createNamedQuery("Employee.findAll").getResultList();
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();

        if(listEmployees == null) {
            System.out.println("No Employees found");
        } else {
            System.out.println("List not null");
            listEmployees.forEach(System.out::println);
        }

    }
}
