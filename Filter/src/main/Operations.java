package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Item;
import model.User;

public class Operations {
	public static void insert() throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Item[] item=new Item[50];
		int j=2;
		System.out.println("Number of items to be inserted:");
		Integer n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			System.out.println("Enter the item name:");
			item[j]=new Item();
			item[j].setiName(bf.readLine());
			System.out.println("Enter the price:");
			item[j].setPrice(Integer.parseInt(bf.readLine()));
			System.out.println("Enter the quantity:");
			item[j].setQuantity(Integer.parseInt(bf.readLine()));
			System.out.println("Enter the Expiry Date:");
			item[j].seteDate(bf.readLine());
			System.out.println("Enter the Manufacturing Date:");
			item[j].setmDate(bf.readLine());
			session.save(item[j]);
			j++;
		}
		session.getTransaction().commit();
		session.close();
	}
	public static void retrieve(){ 
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Item");
		List<Item> list= query.getResultList();
		for(Item each:list){
			System.out.println(each.getId()+"   "+each.getiName()+"   "+each.getPrice()+"   "+each.getQuantity()+"   "+each.getmDate()+"   "+each.geteDate());
		}
		session.getTransaction().commit();
		session.close();
	}
	public static void update() throws NumberFormatException, IOException{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Item");
		List<Item> list= query.getResultList();
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the item id to be updated:");
		int ch=Integer.parseInt(bf.readLine());
		//System.out.println(item[ch-1].getiName());
		
		for(Item each:list){
			if(ch==each.getId()){
				System.out.println("Enter the new item name:");
				String ite=bf.readLine();
				each.setiName(ite);
			}
			//System.out.println(each.getId()+"   "+each.getiName()+"   "+each.getPrice()+"   "+each.getQuantity()+"   "+each.getmDate()+"   "+each.geteDate());
		}
		
		session.getTransaction().commit();
		session.close();
	}
	public static void delete() throws NumberFormatException, IOException{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Entert the item id to be deleted:");
		int ch=Integer.parseInt(bf.readLine());
		Query query=session.createQuery("from Item");
		List<Item> list= query.getResultList();
		for(Item each:list){
			if(ch==each.getId()){
				session.delete(each);
			}
		}
		session.getTransaction().commit();
		session.close();
	}

	
}
