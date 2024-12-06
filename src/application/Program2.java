package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n==== TEST 1: department Insert ====");
		Department newDepartment = new Department(null, "Games");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id: " + newDepartment.getId());
		
		System.out.println("\n==== TEST 2: department FindById ====");
		Department department = departmentDao.findById(4);
		System.out.println(department);
		
		System.out.println("\n==== TEST 3: department Update ====");
		department = departmentDao.findById(1);
		department.setName("Developer");
		departmentDao.update(department);
		System.out.println("Update Completed!");
		
		System.out.println("\n==== TEST 4: department DeleteById ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");
		
		
		
		sc.close();
	}

}
