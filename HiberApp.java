package study.entity;

import java.sql.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HiberApp {
	
	public static int getChoice()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n1.Add a new prod ");
		System.out.println("2.Change the product properties ");
		System.out.println("3.Delete a product");
		System.out.println("4.Show details of a product with a given id");
		System.out.println("5. Quit");
		System.out.print("Enter Choice   :      ");
		return sc.nextInt();
	}
	

	public static void main(String[] args) {

		Session session = getSession();
		int choice;
		
		
		while((choice=getChoice()) != 5)
		{
			switch(choice)
			{
			case 1:
				addProduct(session);
				System.out.println("=======================================\n\n");
				break;
			case 2:
				change_Property(session);
				System.out.println("=======================================\n\n");
                break;
			case 3:
				delete_Product(session);
				System.out.println("=======================================\n\n");
                break;
			case 4:
				get_All_Details(session);
				System.out.println("=======================================\n\n");
                break;
			case 5:
				break;
			}
		}
		
		
		
	}
	
	private static void get_All_Details(Session session) {
		Scanner sc = new Scanner(System.in);
         session.beginTransaction();
         System.out.println("Enter ID Number fro getting all details   :   ");
         int id = sc.nextInt();
		
         Grocery gc = session.find(Grocery.class, id);
         System.out.println(gc);
         
         session.getTransaction().commit();
	}


	private static void delete_Product(Session session) {
		Scanner sc = new Scanner(System.in);
		session.beginTransaction();
		System.out.println("Enter ID number That you want to delete   :  ");
		int id =sc.nextInt();
		
		Grocery gc = session.find(Grocery.class, id);
		session.delete(gc);
		session.getTransaction().commit();
	}


	private static void change_Property(Session session) {
		Scanner sc = new Scanner(System.in);
		
		session.beginTransaction();
		
		System.out.println("Enter Product ID   :    ");
		int id = sc.nextInt();
		System.out.println("Enter New Product Name   :    ");
		sc.nextLine();
		String name = sc.nextLine();
		
		Grocery gc = session.find(Grocery.class, id);
		
		gc.setProduct_name(name);
		
		session.getTransaction().commit();
	}


	private static void addProduct(Session session) {
		session.beginTransaction();
		
		Grocery gc = Populate_Grocery();
		session.save(gc);
		session.getTransaction().commit();
		
	}

	
	

	private static Grocery Populate_Grocery() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product_id   :   ");
		int id = sc.nextInt();
	
		
		System.out.println("Enter product_name   :   ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("Enter product_desc   :   ");
		String desc = sc.nextLine();
		
		System.out.println("Enter Unit   :    ");
		int unit = sc.nextInt();
		
		System.out.println("Enter Cost   :    ");
	     float cost = sc.nextFloat();
	     
	     System.out.println("Enter expiry_date    :   ");
	     sc.nextLine();
	     String date = sc.nextLine();
	     
	     Date d = Date.valueOf(date);
	     
	     
	     Grocery gc = new Grocery(id , name , desc , unit , cost , d);
	
		return gc;
	}


	public static Session getSession()
	{
		//READING the hibernate.cfg.xml  from the classpath 
		  StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
	    // Create MetadataSources
	    MetadataSources sources = new MetadataSources(registry);
	    // Create Metadata
	    Metadata metadata = sources.getMetadataBuilder().build();
	    // Create SessionFactory
	    SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
	   
	    Session session = sessionFactory.openSession(); // start a transaction
		
	    return session;
	}


	

}
