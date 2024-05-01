package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerStatus;


public class Main {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entrego com o nome do Departamento: ");
		String nameDeparta = sc.nextLine();
		System.out.println("Enter Worker Date: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerStatus.valueOf(workerLevel), baseSalary, new Departament(nameDeparta));
		
		System.out.println("Quantos contratos o trabalhador vai ter? ");
		int quantContratos = sc.nextInt();
		
		for(int i=0;i<quantContratos;i++) {
			System.out.println("Entre com contrato "+ i +" data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = spd.parse(sc.next());
			System.out.print("Valor pro hora: ");
			double valueHora = sc.nextDouble();
			System.out.print("Duração(Hour): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valueHora, hours);
			worker.addContract(contract);
		}
		
		System.out.print("Entre com o mês e ano (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 1));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: " + worker.getDepartament().getName());
		System.out.println("Income for "+ monthAndYear +": "+ String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
}
