package utilities;

import com.github.javafaker.Faker;

public class RandomData_Utility {
	
	
static Faker faker;


	public static String getPrefix()
	{
		faker =new Faker();
		String prefix =faker.name().prefix();
		return prefix;
	}
	
	public static String getFirtName()
	{
		faker = new Faker();
		String first_name =faker.name().firstName();
		return first_name;
	}
	
	public static String getLastName()
	{
		faker = new Faker();
		String last_name = faker.name().lastName(); 
		return last_name;
	}
	
	public static String getPercent()
	{
	faker = new Faker();
	String salecommission = faker.number().digit();
	return salecommission;
	}
}


