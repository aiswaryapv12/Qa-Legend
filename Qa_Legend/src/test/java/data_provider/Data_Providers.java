package data_provider;

import org.testng.annotations.DataProvider;

public class Data_Providers {
	
	@DataProvider(name ="invalidUserCredentials")
	public Object[][] user_Credential_Data() 
	{
		Object[][] data = new Object[3][2];
		data[0][0] ="aiswaryassj@gmail.com";
		data[0][1]= "123456789";
		
		data[1][0]="aiswaryapv25@gmail.com";
		data[1][1] ="475554";
		
		data[2][0] ="aissilaosj@gmail.com";
		data[2][1] ="756858";
		
		return data;
	}


}
