package org.formation.repository;

import java.util.List;

import org.formation.model.Livraison;
import org.formation.model.Livreur;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LivraisonRepositoryTest {

	@Autowired
	ApplicationContext context;
	
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LivraisonRepository repository;
    
    
    @Before
    public void setup() {
      
    	Livraison l = new Livraison();
    	l.setNoCommande("1234");
    	entityManager.persist(l);
      
        
    }
    @Test
    public void testFindAll() throws Exception {
    	
    	List<Livraison> livraisons = repository.findAll();
    	assert !livraisons.isEmpty();
    }
    @Test
    public void testFindById() throws Exception {

        assert repository.findById(1l) != null;
    }
    @Test
    public void testFindByLivreur() throws Exception {
        Livreur livreur = new Livreur();
        livreur.setId(1l);
        assert repository.findByLivreur(livreur).isEmpty();
    }
    
    
}
