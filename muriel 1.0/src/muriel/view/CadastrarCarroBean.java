package muriel.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import muriel.model.Carro;

@ManagedBean
@ApplicationScoped
public class CadastrarCarroBean {
	
	private List<Carro> carros;
	private Carro carro;
	private int codExcluir;
	
	public CadastrarCarroBean() {
		this.carros = new ArrayList<Carro>();
    	this.carro = new Carro();
	}

	public void cadastrar() {
		this.carros.add(this.carro);		
		System.out.println("Carro cadastrado!");
		salvar();
		this.carro = new Carro();
	}
	
	public void salvar() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();		
			em.persist(carro);
			em.getTransaction().commit();
			
			System.out.println("Carro salvo com sucesso!");
			em.close();
	}
	
	public void remover(int x) {
		x = codExcluir;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Carro carro = em.find(Carro.class, x);

		em.getTransaction().begin();
		em.remove(carro); 
		em.getTransaction().commit();
		
		System.out.println("Carro removido com sucesso");
		
		em.close();

	}
	
	public void consultar(int x) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Carro carro = em.find(Carro.class, x );
		
		System.out.println("Carro consultado com sucesso");
		
		em.close();

	}
	
	public void alterar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Carro carro = em.find(Carro.class, 2L);
		
		em.getTransaction().begin();
		carro.setModelo("Ka");
		carro.setMarca("Ford");
		em.getTransaction().commit();
		
		System.out.println("Carro alterado com sucesso!");

	}

	public Carro getCarro() {
		return carro;
	}

	public List<Carro> getCarros() {
		return carros;
	}	

	
}
