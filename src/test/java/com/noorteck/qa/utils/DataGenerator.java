package com.noorteck.qa.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;

import com.github.javafaker.Faker;

public class DataGenerator extends JsonFileUtils {

	public void updateEmpID(String apiName, String region, String indexStr, String id)
			throws JSONException, IOException {
		int index = Integer.parseInt(indexStr);

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("employeeId", Integer.parseInt(id));

		modifyTestData(map, apiName, region, index);

	}

	public void gernerateJobData(String apiName, String region, String indexStr) throws JSONException, IOException {
		int index = Integer.parseInt(indexStr);
		Faker fakeData = new Faker();
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		String jobID = fakeData.company().profession();
		
		//TODO check with the database and see if the jobID we have is already in DB
		
		// if it does then go back and regeneate and re check until it is unique
		
		if(jobID.length() > 8) {
			jobID= jobID.substring(0,8);
		}

		String jobTitle = fakeData.company().industry();

		double minSalary = fakeData.number().numberBetween(1000, 99999);
		double maxSalary = fakeData.number().numberBetween(1000, 99999);

		if (maxSalary < minSalary) {
			double temp = maxSalary;
			maxSalary = minSalary;
			minSalary = temp;
		}
		
		map.put("jobId", jobID);
		map.put("jobTitle", jobTitle);
		map.put("minSalary", minSalary);
		map.put("maxSalary", maxSalary);

		modifyTestData(map, apiName, region, index);


		System.out.println(jobID);
		System.out.println(jobTitle);
		System.out.println(minSalary);
		System.out.println(maxSalary);
	}

	public void gernerateEmployeeData(String apiName, String region, String indexStr)
			throws JSONException, IOException {
		int index = Integer.parseInt(indexStr);

		Faker fakeData = new Faker();
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();

		String email = firstName + "@test.com";
		String phone = fakeData.phoneNumber().cellPhone();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String hireDate = sdf.format(fakeData.date().birthday());

		double minSalary = 10000;
		double maxSalary = 200000;

		double salary = minSalary + (maxSalary - minSalary) * fakeData.random().nextDouble();

		salary = Double.parseDouble(String.format("%.2f", salary));
		double minCommission = 0.0;
		double maxCommission = 0.8;
		double commission = minCommission + (maxCommission - minCommission) * fakeData.random().nextDouble();

		commission = Double.parseDouble(String.format("%.2f", commission));

		map.put("firstName", firstName);
		map.put("lastName", lastName);
		map.put("email", email);
		map.put("phoneNumber", phone);
		map.put("salary", salary);
		map.put("comissionPct", commission);

		System.out.println("FirstName: " + firstName);
		System.out.println("LastName: " + lastName);
		System.out.println("Email: " + email);
		System.out.println("Phone: " + phone);
		System.out.println("Date: " + hireDate);
		System.out.println("Salary: " + salary);
		System.out.println("Commission: " + commission);

		modifyTestData(map, apiName, region, index);

	}

}
