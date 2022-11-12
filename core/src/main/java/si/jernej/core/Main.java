package si.jernej.core;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import si.jernej.entity.EmployeeEntity;

public class Main
{
    public static void main(String[] args)
    {
        EmployeeEntity employee = new EmployeeEntity();
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("primary");
        EntityManager em = factory.createEntityManager();

        List<EmployeeEntity> employees = em.createQuery("SELECT e FROM EmployeeEntity e", EmployeeEntity.class)
                .getResultList();

        System.out.println(employees.size());
    }
}
