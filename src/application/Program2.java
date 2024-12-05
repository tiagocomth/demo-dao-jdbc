package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n==== TEST 1: department Insert ====");
		Department newDepartment = new Department(null, "Games");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id: " + newDepartment.getId());
	}

}
