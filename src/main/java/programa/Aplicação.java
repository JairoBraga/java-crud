package programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Usuario;

public class Aplicação {

	public static void main(String[] args) {
		Usuario s1 = new Usuario(null,"Carlos","Carlos@gmail.com");
		Usuario s2 = new Usuario(null,"Roberto","Roberto@gmail.com");
		Usuario s3 = new Usuario(null,"João","João@gmail.com");
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Persistir dados
		em.getTransaction().begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.getTransaction().commit();
		
		Usuario s4 = em.find(Usuario.class, 1);
		System.out.println(s4);
		System.out.println("pronto");
		em.close();
		emf.close();
	}

}
