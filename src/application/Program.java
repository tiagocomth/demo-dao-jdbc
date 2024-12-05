package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller FindById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller FindByDepartment ====");
		Department dep = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller s : list) 
			System.out.println(s);
		
		System.out.println("\n==== TEST 3: seller FindALL ====");
		list = sellerDao.findAll();
		for(Seller s : list) 
			System.out.println(s);
		
		System.out.println("\n==== TEST 4: seller Insert ====");
		Seller newSeller = new Seller(null, "Gred", "Greg@gmail.com", new Date(), 4000.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id: " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller Update ====");
		seller = sellerDao.findById(1);
		seller.setName("Neymar Junior");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		System.out.println("\n==== TEST 5: seller DeleteById ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed");
		
		
		sc.close();
		
	}
}
