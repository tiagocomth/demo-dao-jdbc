package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
	
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
	}
}
