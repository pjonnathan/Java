package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerStatus;

public class Worker {
	private String name;
	private WorkerStatus level;
	private Double salary;
	
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();
	
	
	
	
	public Worker(String name, WorkerStatus level, Double salary, Departament departament) {
		this.name = name;
		this.level = level;
		this.salary = salary;
		this.departament = departament;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public WorkerStatus getLevel() {
		return level;
	}


	public void setLevel(WorkerStatus level) {
		this.level = level;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public Departament getDepartament() {
		return departament;
	}


	public void setDepartament(Departament departament) {
		this.departament = departament;
	}


	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	
	public double income(int year, int month) {
		double sum = salary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		
		return sum;
	}
	
	
	
}
