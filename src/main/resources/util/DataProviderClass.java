package util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	// @DataProvider(name = "discountData", parallel = true)
	@DataProvider(name = "discountData")
	public Object[][] discountData() {
		Object[][] data = new Object[3][5];

		data[0][0] = "selenium";
		data[0][1] = "3";
		data[0][2] = "20";
		data[0][3] = "11/4/2019 12:00 AM";
		data[0][4] = "11/5/2019 12:00 AM";

		data[1][0] = "webdriver";
		data[1][1] = "2";
		data[1][2] = "10";
		data[1][3] = "11/4/2019 12:30 AM";
		data[1][4] = "11/5/2020 12:00 AM";

		data[2][0] = "automation";
		data[2][1] = "1";
		data[2][2] = "15";
		data[2][3] = "11/4/2020 12:00 AM";
		data[2][4] = "11/5/2021 12:00 AM";

		return data;
	}
}