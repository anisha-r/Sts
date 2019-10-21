package com.anisha;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends PagingAndSortingRepository<Employ, Integer>{
	
	@Query("SELECT e FROM Employ e WHERE dept=?1")
	
	List<Employ>findByDept(String dept);
	
   @Query("SELECT e FROM Employ e WHERE name=?1")
	
	List<Employ>findByName(String name);
	
   @Query("SELECT e FROM Employ e WHERE dept=?1 AND desig=?2")
	
	List<Employ>findByDeptAndDesig(String dept,String desig);
   
   @Query("SELECT e FROM Employ e WHERE  basic>?1")
	
 	List<Employ>findByBasic(Integer basic);
   
   @Query("SELECT e FROM Employ e WHERE dept=?1 AND desig=?2 AND basic>?3")
	
  	List<Employ>findByDeptAndDesigAndBasic(String dept,String desig,Integer basic);
   
   
   @Query("SELECT e FROM Employ e WHERE dept=?1 AND desig=?2 AND basic>?3 AND name LIKE 'A%'")
	
  	List<Employ>findByDeptAndDesigAndBasicAndName(String dept,String desig,Integer basic);
   
   @Query("SELECT e FROM Employ e WHERE  desig=?1 AND basic>?2 AND name LIKE 'A%'")
   
   List<Employ>findByThree(String desig,Integer basic);


	
 	


//	public void addEmployee(Employ employee);
//
//	public List<Employ> getAllEmployees(); 
//
//	public void  deleteEmployee(Integer empno);
//
//	public Employ updateEmployee(Employ employee);

//	public Employ getEmploy(int employeeid);

}
