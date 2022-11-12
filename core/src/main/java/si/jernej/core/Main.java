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
        // jakarta.persistence.Persistence is a bootstrap class that is used to obtain an EntityManagerFactory in Java SE environments.
        // The class is also used to obtain a PersistenceUtil instance in both Jakarta EE and Java SE environments.

        // A persistence unit defines a set of all entity classes that are managed by EntityManager instances in an application.
        // This set of entity classes represents the data contained within a single data store. When creating an EntityManagerFactory instance, we refer to the persistence unit by its name
        // as defined in the persistence.xml.

        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary"); EntityManager em = entityManagerFactory.createEntityManager())
        {
            List<EmployeeEntity> employees = em.createQuery("SELECT e FROM EmployeeEntity e", EmployeeEntity.class).getResultList();
            assert !employees.isEmpty();
        }
    }
}
