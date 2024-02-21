package com.spring.orm;

import java.util.Scanner;
import com.spring.orm.dao.*;
import com.spring.orm.entity.*;

import java.util.List;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main( String[] args )
    {	
        ApplicationContext context = new ClassPathXmlApplicationContext("/config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	System.out.println("Press 1 to Add new Student");
        	System.out.println("Press 2 to Display All Student");
        	System.out.println("Press 3 to Get Single Student");
        	System.out.println("Press 4 to Delete Student");
        	System.out.println("Press 5 to Update Student");
        	System.out.println("Press 6 to Exit");
        	int choice = sc.nextInt();
        	if(choice==1)
        	{
        		int id;
        		String name,city;
        		System.out.print("Enter the Id: ");
        		id = sc.nextInt();
        		sc.nextLine();
        		System.out.print("Enter the Name: ");
        		name = sc.nextLine();
        		System.out.print("\nEnter the City: ");
        		city = sc.nextLine();
        		Student st = new Student(id,name,city);
        		int r = studentDao.insert(st);
        		System.out.println("Inserted Successfully with Id: "+r);
        	}
        	else if(choice==2)
        	{
        		List<Student> li = studentDao.getAll();
        		for(Student ele : li)
        			System.out.println(ele);
        	}
        	else if(choice==3)
        	{
        		System.out.print("Enter the Id: ");
        		int ide = sc.nextInt();
        		Student s = studentDao.get(ide);
        		System.out.println(s);
        	}
        	else if(choice==4)
        	{
        		System.out.print("Enter the Id: ");
        		int id = sc.nextInt();
        		studentDao.Delete(id);
        		System.out.println("Deleted Successfully!!");
        	}
        	else if(choice==5)
        	{
        		int ids;
        		String name,city;
        		System.out.print("Enter the Id: ");
        		ids = sc.nextInt();
        		sc.nextLine();
        		System.out.print("Enter the Name: ");
        		name = sc.nextLine();
        		System.out.print("Enter the City: ");
        		city = sc.nextLine();
        		Student s = new Student(ids,name,city);
        		studentDao.Update(s);
        		System.out.println("Updated Successfully!!");
        	}
        	else
        	{
        		System.out.println("Thank you!!");
        		break;
        	}
        }
       
    }
}
