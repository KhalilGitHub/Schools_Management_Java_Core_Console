package com.cameroun.objis.smc.presentation;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cameroun.objis.smc.domaine.Recrutment;
import com.cameroun.objis.smc.domaine.Registration;
import com.cameroun.objis.smc.domaine.User;
import com.cameroun.objis.smc.service.IService;
import com.cameroun.objis.smc.service.Service;
import com.cameroun.objis.smc.utils.ConnectionMysql;
import com.cameroun.objis.smc.utils.ReadInput;
import com.cameroun.objis.smc.utils.ReadKeyboard;

/***********************************************************************************
 * 
 * 			School Management System
 * 			@author Khalil Hisseine Hamdane
 * 			E-mail:hamdane.khalil.hisseine@gmail.com
 * 			Tel: +237 - 651420937
 * 
 ************************************************************************************/

public class App {

	public static void main(String[] args) throws SQLException, IOException, InterruptedException {
		
		
		
		 char reponse = 'Y';
	        while (reponse == 'Y' || reponse == 'y')
	        {
	           System.out.println( "---------------------------------------------" );
	            System.out.println( "    Welcome to School Management System     " );
	            System.out.println( "\nLogin: hamdane                            " );
	            System.out.println( "Password: 123                               " );
	            System.out.println( "--------------------------------------------" );
	            
	       
	            new App();
	            
	            System.out.println("\n"+"\n");
	            System.out.println("Do you need anothers Operations? (Y/N)");
	            reponse = ReadKeyboard.readChar();
	        }
	        	        
	        System.out.println("Good by . . .");
	}
	

	public App() {
		String login = null;
		String password = null;
		
		try {
			System.out.println("\n");
			System.out.println("To access this system enter your User Name: ");
			login = ReadKeyboard.readString();
			System.out.println("\nTo access this system enter your User Name: ");
			password = ReadKeyboard.readString();
			loginSysteme(login, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loginSysteme(String login, String password) throws SQLException
	{
		User User = null;
		IService service = new Service();
		Connection conn = ConnectionMysql.getInstance();
		
		User = service.loginUserService(conn, login, password);
		if(User.getLogin().equals(login) && User.getPassword().equals(password))
		{
			try {
				choice();
			} catch (ClassNotFoundException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Login or Password incorrect !!!");
		}
	}
	
	public static void registration() throws InterruptedException, ClassNotFoundException
	{
		Service service = new Service();
		Connection conn;
		String register_ref;
		List<Registration> lRegistration = new ArrayList<>();
	     
	     int choix=0;
		try {
			conn = ConnectionMysql.getInstance();
			
		     while(choix!=5)
		     {
		         System.out.println("\n1. New Student Registration.");
		         System.out.println("\n2. Dispaly the list of all Register Student");
		         System.out.println("\n3. Student Registration Update");
		         System.out.println("\n4. Delete Student Registration");
		         System.out.println("\n5. Exit");
		         
		         System.out.println("\nEnter your choice : ");
		         choix=ReadKeyboard.readInt();
		         switch(choix)
		         {
		         
		             case 1 : 
		            	 	service.saveRegistrationService(conn, ReadInput.SaveRegistration());
		            	 	lRegistration = service.getAllRegistrationsService();
			            	 for (Registration registration : lRegistration) {
								System.out.println(registration);
							}
		             		Thread.sleep( 2000 );
		             		break;
		             
		             case 2 : 
			            	 lRegistration = service.getAllRegistrationsService();
			            	 for (Registration registration : lRegistration) {
								System.out.println(registration);
							}
		             		Thread.sleep( 2000 );
		             		break;
		             		
		             case 3 : 
		             	service.updateRegistrationService(conn, ReadInput.updateRegistration());
		             	lRegistration = service.getAllRegistrationsService();
		            	 for (Registration registration : lRegistration) {
							System.out.println(registration);
						}
		         		Thread.sleep( 2000 );
		         		break;               
		             
		             case 4 : 
		 	            System.out.println("Enter the Registration Id which you want to delete");
		 	            register_ref = ReadKeyboard.readString();
		             	service.deleteRegistrationService(conn, register_ref);
		             	lRegistration = service.getAllRegistrationsService();
		            	 for (Registration registration : lRegistration) {
							System.out.println(registration);
						}
		         		Thread.sleep( 2000 );
		         		break;
		         		
		             case 5:
		            	 System.out.println("You leaved the Student Registration session... ");
		            	 break;
		                         
		             default:
		            	 System.out.println("You enter an invalid choice!!!");
		            	 break;
		         }
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void recrutment() throws InterruptedException, ClassNotFoundException
	{
		Service service = new Service();
		Connection conn;
		String register_ref;
		List<Recrutment> lRecrutment = new ArrayList<>();
	     
	     int choix=0;
		try {
			conn = ConnectionMysql.getInstance();
			
		     while(choix!=5)
		     {
		         System.out.println("\n1. New Teacher Recrutment.");
		         System.out.println("\n2. Dispaly the list of all Teacher Recrutmented");
		         System.out.println("\n3. Teacher informations Update");
		         System.out.println("\n4. Delete Student Teacher informations"); 
		         System.out.println("\n5. Exit");
		         
		         System.out.println("\nEntrer votre choix : ");
		         choix=ReadKeyboard.readInt();
		         switch(choix)
		         {
		         
		             case 1 : 
		            	 	service.saveRecrutmentService(conn, ReadInput.SaveRecrutment());
		            	 	lRecrutment = service.getAllRecrutmentsService();
		            	 	for (Recrutment recrutment : lRecrutment) {
								System.out.println(recrutment);
							}
		             		Thread.sleep( 2000 );
		             		break;
		             
		             case 2 : 
		            	 lRecrutment = service.getAllRecrutmentsService();
		            	 	for (Recrutment recrutment : lRecrutment) {
								System.out.println(recrutment);
							}
		             		Thread.sleep( 2000 );
		             		break;
		             		
		             case 3 : 
		             	service.updateRecrutmentService(conn, ReadInput.updateRecrutment());
		             	lRecrutment = service.getAllRecrutmentsService();
	            	 	for (Recrutment recrutment : lRecrutment) {
							System.out.println(recrutment);
						}
		         		Thread.sleep( 2000 );
		         		break;               
		             
		             case 4 : 
		 	            System.out.println("Enter the Recrutment Id which you want to delete");
		 	            register_ref = ReadKeyboard.readString();
		             	service.deleteRecrutmentService(conn, register_ref);
		             	lRecrutment = service.getAllRecrutmentsService();
	            	 	for (Recrutment recrutment : lRecrutment) {
							System.out.println(recrutment);
						}
		         		Thread.sleep( 2000 );
		         		break;
		                   
		             case 5:
		            	 System.out.println("You leaved the recruiting session... ");
		            	 break;
		         		
		             default:
		            	 System.out.println("You enter an invalid choice!!!");
		            	 break;
		         }
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void choice() throws ClassNotFoundException, InterruptedException, SQLException {
		
		 int choix=0;
			while(choix!=2)
			 {
			     System.out.println("\n1. Students Managment");
			     System.out.println("\n2. Teachers Managment");
			     
			     System.out.println("\nEntrer votre choix : ");
			     choix=ReadKeyboard.readInt();
			     switch(choix)
			     {
			     
			         case 1 : 
			        	    registration();
			         		Thread.sleep( 2000 );
			         		break;
			         
			         case 2 : 
			        	 	recrutment();
			         		Thread.sleep( 2000 );
			         		break;
			                     
			         default:
			        	 System.out.println("You enter an invalid choice!!!");
			        	 break;
			     }
		  }
	}

}
