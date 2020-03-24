package jpa;

import entities.RedSocial;
import entities.Usuario;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carls
 */
public class JPARedSocial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JPA_Red_SocialPU");
        EntityManager entityManager = managerFactory.createEntityManager(); 
        
        entityManager.getTransaction().begin();
        
        Usuario usuario=new Usuario();
        usuario.setNombre("Juan");
        usuario.setFechaNacimiento("05/05/2000");
        usuario.setCorreoElectronico("lawea@hotmail.com");
        usuario.setSexo("Hombre");
        System.out.println(usuario.getEdad());
        
        RedSocial red=new RedSocial();
        red.setNombre("facebook");
        red.setSitioWeb("facebook.com");
        red.setFechaInicioOperaciones("15/05/2005");
        System.out.println(red.getFechaInicioOperaciones());
        System.out.println(red.getNombre());
        
        
        usuario.addRedSocial(red);
        
       for (Iterator i = usuario.getRedesSociales().iterator(); i.hasNext(); ) 
       System.out.println(i.next().toString());
        
        for (Iterator i = red.getUsuarios().iterator(); i.hasNext(); ) 
       System.out.println(i.next().toString());
        
        entityManager.persist(usuario);
        entityManager.persist(red);
        
        entityManager.getTransaction().commit();
    }
    
}
