package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		
		for(Seller obj: list) {
			System.out.println(obj);
		}	
		
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
			
		for(Seller obj: list) {
		System.out.println(obj);
		}
		
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, new Department(2, null));
		//sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		

		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(9);
		seller.setName("Kelvin");
		seller.setEmail("Kelvin@hotmail.com");
		seller.setBaseSalary(1000.00);
		seller.setBirthdate(sdf.parse("31/04/2017"));
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete ===");
		sellerDao.deleteById(12);
		System.out.println("Delete completed");
	
	}

}
