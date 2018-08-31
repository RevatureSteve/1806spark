package com.example.HibernateDemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.example.mappings.Bear;
import com.example.mappings.Cave;
import com.example.mappings.HoneyPot;

public class App {
	
	static SessionFactory sessionFactory;
	
	/**
	 *	 States of Hibernate:
	 *			-transient: not yet connected to db
	 *			-persistent: currently connected to db (allows automatic dirty checking)
	 *			-detached: was connected
	 */
    public static void main( String[] args ) throws InterruptedException{
        App app = new App();
    	sessionFactory = 
    			app.createSessionFactory();
    	
    	// Please select a method to test
//    	app.createBearsDemo();
    	app.getAndLoadDemo();
//    	app.loadDemo();
//    	app.getDemo();
//    	Thread.sleep(6000);
//    	app.getDemo();
//    	app.hqlDemo();
    	
    }
    
    public SessionFactory createSessionFactory(){
    	sessionFactory =
        		new Configuration().
        		configure().
        		buildSessionFactory();
        System.out.println("Built Session Factory");
        return sessionFactory;
    }
    
    public void createBearsDemo(){
    	 Session session = sessionFactory.openSession();
         Transaction tx = session.beginTransaction();
         
         // Roaming bears looking for place to hibernate
         Bear parent = new Bear(null, 
     						new HoneyPot(100, 100), 
     						"black", 
     						"black bear", 
     						225, 
     						89);
         session.save(parent.getHoneyPot());
         
         // Bear has a little cub!
         Bear child = new Bear(null, 
         					new HoneyPot(30, 30), 
 							"brown", 
 							"brown bear", 
 							215, 
 							84);
         parent.getBearCubs().add(child);
         session.save(child.getHoneyPot());

         // They find a cave
         Cave newHome = new Cave(585, "warm cave");
         
         // They enter into the cave
         parent.setDwelling(newHome);
         child.setDwelling(newHome);
         
         session.save(newHome);
         session.save(parent);
         session.save(child);
         tx.commit();
         System.out.println("TIME TO HIBERNATE");
         
    }
    
    public void getAndLoadDemo(){
        Session session = sessionFactory.openSession();
        /*
         * https://stackoverflow.com/questions/5370482/whats-the-advantage-of-load-vs-get-in-hibernate
         *  Get vs Load: Both pull an object/record from the DB
         *  	-Get: returns a persistent instance or null
         *  	-Load: returns the persistent instance or proxy (fake object)
         *  		*Load doesn't hit the db first, instead loads proxy object until the dev 
         *  			actually requires to use the object while in the persisted state.
         *  			If the session is closed before using the object is used it will throw a
         *  			LazyInitializationException once used!*
         *  
         *  	If object doesn't exist in DB
         *  	-Get: return null
         *  	-Load: ObjectNotFoundException
         *  
         */
//        Bear bearGet = (Bear) session.get(Bear.class, 1000);
//        session.close();
//        System.out.println("Get: " + bearGet.toString());
        
        Bear bearLoad = (Bear) session.load(Bear.class, 1000);
        System.out.println("Load: " + bearLoad.toString());

//        Bear bearGetFail = (Bear) session.get(Bear.class, 200);
//        System.out.println("Get fail: " + bearGetFail);
//        
//        Bear bearLoadFail = (Bear) session.load(Bear.class, 200);
//        System.out.println("Load fail: " + bearLoadFail);
    }
    
    public void loadDemo(){
    	Session session = sessionFactory.openSession();
    	System.out.println("--------------Load Bear-----------\n");
    	Bear bearLoad= (Bear) session.load(Bear.class, 50);
    	System.out.println("Loading bear: " + bearLoad.toString() + "\n");
    	System.out.println(bearLoad.getClass());
    	session.close();
    	//bearLoad is now detached - LazyInitializationException
    	System.out.println("Loading bear: " + bearLoad.toString());
    }

    public void getDemo(){
    	Session session = sessionFactory.openSession();
    	System.out.println("--------------Get Bear-----------\n");
    	Bear bearGet = (Bear) session.get(Bear.class, 50);
    	session.close();
    	System.out.println("Getting bear: " + bearGet.toString() + "\n");
    }
    
    public void hqlDemo(){
    	Session session = sessionFactory.openSession();
    	Query query;
    	String hql;
    	Transaction tx;
    	
    	System.out.println("*-----Get all Bears-----*");
    	hql = "FROM com.example.mappings.Bear";
    	query = session.createQuery(hql);
    	List bears = query.list();
    	for(Object bear : bears){
    		bear = (Bear) bear;
    		System.out.println(bear);
    	}
    	
    	System.out.println("*-----Get all Bears shorter than 85 inches-----*");
    	hql = "FROM Bear AS b WHERE b.height < 85";
    	session = sessionFactory.openSession();
    	query = session.createQuery(hql);
    	bears = query.list();

    	for(Object bear : bears){
    		bear = (Bear)bear;
    		System.out.println(bear);
    	}
    	
    	System.out.println("*-----Get all Brown Bears-----*");
    	hql = "FROM Bear AS b WHERE b.bearColor = :fur";
    	session = sessionFactory.openSession();
    	query = session.createQuery(hql);
    	query.setParameter("fur", "brown");
    	bears = query.list();

    	for(Object bear : bears){
    		bear = (Bear) bear;
    		System.out.println(bear);
    	}
    	
    	System.out.println("*-----Get One Bear-----*");
    	hql = "FROM com.example.mappings.Bear WHERE bearId = :bearNum";
    	session = sessionFactory.openSession();
    	query = session.createQuery(hql);
    	query.setParameter("bearNum", 501);
    	Bear bear = (Bear) query.uniqueResult();
    	System.out.println(bear);

    	
    	System.out.println("*-----Feeding a bear before Hibernation-----*");
    	hql = "UPDATE Bear SET weight = weight + :fat WHERE bearId = :bearId";
    	Bear bear500 = (Bear) session.get(Bear.class, 500);
    	System.out.println("Weight Before: " + bear500.getWeight());
    	tx = session.beginTransaction();
    	query = session.createQuery(hql);
    	query.setDouble("fat", 5.0);
    	query.setParameter("bearId", 500);
    	int rowsUpdated = query.executeUpdate();
    	tx.commit();
    	System.out.println(rowsUpdated + " bears updated!");
    	
    }
    
    public void nativeSQLDemo(){
    	Session session = sessionFactory.openSession();
    	SQLQuery sqlQuery;
    	
    	String nativeSQL = "SELECT * "
    			+ "FROM Bear "
    			+ "WHERE bear_color = :colorSearch";
    	sqlQuery = session.createSQLQuery(nativeSQL);
    	sqlQuery.addEntity(Bear.class);
    	sqlQuery.setParameter("colorSearch", "black");
    	List bears = sqlQuery.list();
    	for(Object bear : bears){
    		bear = (Bear) bear;
    		System.out.println(bear.toString());
    	}
    }
    
    public void criteriaDemo(){
    	Session session = sessionFactory.openSession();
    	Criteria criteria;
    	
    	System.out.println("*-----List all Bears-----*");
    	List bears = session.createCriteria(Bear.class).list();
    	for(Object bear : bears){
    		bear = (Bear) bear;
    		System.out.println(bear);
    	}
    	
    	System.out.println("*-----List all Brown Bears-----*");
    	bears = session.createCriteria(Bear.class)
					.add(Restrictions.ilike("bearColor", "brown"))
					.list();
    	for(Object bear : bears){
    		bear = (Bear) bear;
    		System.out.println(bear);
    	}
    	
    	System.out.println("*-----List Number of Bears in Forest-----*");
    	Long bearCount = (Long) session.createCriteria(Bear.class)
    			.setProjection(Projections.count("bearId"))
    			.uniqueResult();
    	System.out.println("Number of bears: " + bearCount);
    }
    
    public void namedQueriesDemo(){
    	Session session = sessionFactory.openSession();
    	Query query = session.getNamedQuery("getAllHoneypots");
    	Query nativeQuery = session.getNamedQuery("getSmallHoneypots");
    	nativeQuery.setParameter("maxSizeToBeConsideredSmall", 50);
    	System.out.println("*-----All HoneyPots-----*");
    	List test = query.list();
    	for(Object pot : test){
    		System.out.println(pot);
    	}
    	System.out.println("*-----Small HoneyPots-----*");
    	List testNative = nativeQuery.list();
    	for(Object pot : testNative){
    		System.out.println(pot);
    	}
    }
}
