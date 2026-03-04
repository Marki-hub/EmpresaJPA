/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entity.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import util.JPAUtil;

/**
 *
 * @author marki
 */
public class EmpleadoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    
 
    public void insertar( Empleado e) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }


    public void actualizar(Empleado e) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
    }


    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Empleado.class, id));
        em.getTransaction().commit();
        em.close();
    }


    public Empleado buscar(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Empleado.class, id);
    }


    public List<Empleado> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
    }
    
    public void aumentarSalario(Long id, Double cantidad){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            
            Empleado empleado = em.find(Empleado.class, id);
            if(empleado != null){
                double salarioActual = empleado.getSalario();
                double nuevoSalario = salarioActual + cantidad;
                empleado.setSalario(nuevoSalario);
                
                em.getTransaction().commit();
                System.out.println("Salario actualizado con exito");
            }else{
                System.out.println("Empleado no se encontró");
                em.getTransaction().rollback();
            }
        }catch(Exception e){
            System.err.println("Ocurrió un error y se hizo rollback");
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
}
