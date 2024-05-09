package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Lego;
//import threads.RunLego;


@Path("/lego")
public class LegoService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("lego");	
	
	@Path("/getlego")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getLego() {
		return "Lego service";
	}
	
	@Path("/setvalues")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Lego setValues(Lego lego) {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(lego);
	    em.getTransaction().commit();		
		return lego;
	}
	@Path("/getvalues")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getValues() {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
		Query q=em.createQuery("select s from Lego s order by s.id desc").setMaxResults(1);
		List<Lego> list=q.getResultList();
		em.getTransaction().commit();
		Lego lego=list.get(0);
		return lego.getId()+"#"+lego.getRun()+"#"+lego.getSpeed()+"#"+lego.getTurn();
	}
//    @Path("/playmusic")
//    @POST
//    @Produces(MediaType.TEXT_PLAIN)
//    public String playMusic() {
//        RunLego.playLondonBridgeMusic(); // Call the method to play music
//        return "Music played successfully";
//    }
}
