package muriel.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import muriel.model.Moto;

@ManagedBean
@ApplicationScoped
public class CadastrarMotoBean {
	
	private List<Moto> motos;
	private Moto moto;
	
	public CadastrarMotoBean() {
		this.motos = new ArrayList<Moto>();
    	this.moto = new Moto();
	}
	
	public void cadastrar() {
		this.motos.add(this.moto);		
		System.out.println("Moto cadastrada!");
		salvar();
		this.moto = new Moto();
	}
	
	public void salvar() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();		
			em.persist(moto);
			em.getTransaction().commit();
			
			System.out.println("Carro salvo com sucesso!");
			em.close();
	}

	public Moto getMoto() {
		return moto;
	}

	public List<Moto> getMotos() {
		return motos;
	}	

	
}
