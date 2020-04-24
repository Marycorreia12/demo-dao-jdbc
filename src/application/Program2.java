package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("-----------Insert department------------");
		
		Department dep = new Department(null, "Gold"); 
		//depDao.insert(dep);
		System.out.println("inserted! New Id: " + dep.getId());
		
		
		System.out.println("-----------Update department------------");
		Department obj = depDao.findById(1);
		obj.setName("Music");
		depDao.update(obj);
		System.out.println("Updated id: ");
		
		System.out.println("-----------Delete department------------");
		depDao.deleteById(6);
		System.out.println("Updated id: ");
		
		System.out.println("-----------FindById department------------");
		Department dep1 = depDao.findById(2);
		System.out.println(dep1);
		
		System.out.println("-----------FindAll department------------");
		List<Department> list = depDao.findAll();
		for(Department dep2 : list) {
		System.out.println(dep2);
	 }
	}
}
