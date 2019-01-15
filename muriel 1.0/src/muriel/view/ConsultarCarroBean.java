package muriel.view;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import muriel.model.Carro;

@ManagedBean
public class ConsultarCarroBean {
	
		private List<Carro> carros = new ArrayList<Carro>();
		private Carro carro;
		
		public ConsultarCarroBean() {
			for(int i = 1; i < 30; i++) {
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
				EntityManager em = emf.createEntityManager();
				
				Carro carro = em.find(Carro.class, i );
				
				if(carro != null) {		
					this.carros.add(this.carro);
				} else {
					break;
				}
				
				em.close();
			}
		}

		public List<Carro> getCarros() {
			return carros;
		}

		public void setCarros(List<Carro> veiculos) {
			this.carros = veiculos;
		}

		public Carro getCarro() {
			return carro;
		}

		public void setCarro(Carro carro) {
			this.carro = carro;
		}
		
		

}

