package daoClasses;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Component
public class EmployeeDao {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	static ArrayList<Employee> EMPLOYEE_LIST;
	@SuppressWarnings("unchecked")
	public EmployeeDao() {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
	}
	
	public List<Employee> getAllEmployee(){
		return EMPLOYEE_LIST;
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		
		for(Employee emp:EMPLOYEE_LIST)
		{
			if(emp.getId()==employee.getId())
			{
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setDateOfBirth(employee.getDateOfBirth());
				emp.setPermanent(employee.getPermanent());
				emp.setDepartment(employee.getDepartment());
				emp.setSkill(employee.getSkill());
				
				return emp;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException
	{
		Employee flag=null;
		for(Employee emp:EMPLOYEE_LIST)
		{
			if(emp.getId()==id)
			{
				flag=emp;
						
			}
		}
		if(flag!=null)
		{
			EMPLOYEE_LIST.remove(flag);
		}
		else
		{
			throw new EmployeeNotFoundException();
		}
	}
}