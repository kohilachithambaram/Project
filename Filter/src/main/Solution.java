package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Item;
import model.User;
public class Solution {

	public static void main(String[] args) throws IOException, SQLException {
		String uName;
		String uPassword;
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Item[] item=new Item[50];
		item[0]=new Item();
		item[0].setiName("PEN");
		item[0].setPrice(25);
		item[0].setQuantity(3);
		item[0].seteDate("09-7-2016");
		item[0].setmDate("29-09-2012");
		session.save(item[0]);
		item[1]=new Item();
		item[1].setiName("PENCIL");
		item[1].setPrice(10);
		item[1].setQuantity(10);
		item[1].seteDate("09-10-2016");
		item[1].setmDate("29-11-2012");
		session.save(item[1]);		
		User[] user=new User[3];
		user[0]=new User();
		user[0].setUserName("gugan");
		user[0].setPassword("gugli");
		session.save(user[0]);
		user[1]=new User();
		user[1].setUserName("kohila");
		user[1].setPassword("koki");
		
		session.save(user[1]);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Enter the user name:");
		uName=bf.readLine();
		System.out.println("Enter the password:");
		uPassword=bf.readLine();
		
		User users=new User();
		users.setUserName(uName);
		users.setPassword(uPassword);
		try {
			if (AuthFilter.check(users)) {
				System.out.println("Login Success");
				boolean flag = false;
				while (true) {
					System.out.print("1.Create 2.Retrieve 3.Update 4.Delete\n Choice:");
					int ch=Integer.parseInt(bf.readLine());
					System.out.println(ch);
					switch(ch){
					case 1:
						//System.out.println("Insert Operations:");
						Operations.insert();
						System.out.println("Inserted");
						break;
					case 2:
						Operations.retrieve();
						break;
					case 3:
						Operations.update();
						System.out.println("Inserted");
						break;
					case 4:
						Operations.delete();
						System.out.println("Deleted successfully");
						break;
					default:
						flag=true;
						break;
					}
					if(flag){
					break;
				}
			}
				
		}
			else{
				System.out.println("Invalid Login");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		
	}
		
}

}