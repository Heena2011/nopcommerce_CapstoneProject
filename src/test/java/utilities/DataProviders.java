package utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "RegistrationData")
	public Object[][] getRegistrationData() throws IOException {
		String path = "F:\\CapstoneProject\\nopCommerceProject\\testData\\nopCommereceData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);

		String sheet = "Sheet1";

		// totalRows is actual count (see fixed getRowCount())
		int totalRows = xlutil.getRowCount(sheet);
		int headerRowIndex = 0; // header expected in first row (index 0)
		int totalCols = xlutil.getCellCount(sheet, headerRowIndex);

		int firstDataRow = 1; // data starts at row index 1
		int dataRows = totalRows - firstDataRow;

		if (dataRows <= 0) {
			throw new RuntimeException("No data rows found in sheet: " + sheet + " (totalRows=" + totalRows + ")");
		}

		Object[][] regData = new Object[dataRows][totalCols];

		int idx = 0;
		for (int r = firstDataRow; r < totalRows; r++) { // r from 1 to totalRows-1
			for (int c = 0; c < totalCols; c++) {
				regData[idx][c] = xlutil.getCellData(sheet, r, c);
			}
			idx++;
		}

		// DEBUG - remove after verifying
		System.out.println("RegistrationData produced rows=" + regData.length + " cols=" + regData[0].length);
		System.out.println(Arrays.deepToString(regData));

		return regData;
	}

	// login data provider
//in utilities/DataProviders.java
	@DataProvider(name = "RegisteredUsers")
	public Object[][] getRegisteredUsers() throws IOException {
		String path = "F:\\CapstoneProject\\nopCommerceProject\\testData\\nopCommereceData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);

		String sheet = "Sheet1"; // registration sheet
		int totalRows = xlutil.getRowCount(sheet); // actual count, header included
		int firstDataRow = 1; // header at row 0
		int dataRows = totalRows - firstDataRow;
		if (dataRows <= 0)
			throw new RuntimeException("No data rows in " + sheet);

		// columns: gender(0), firstName(1), lastName(2), email(3), companyName(4),
		// password(5)
		Object[][] data = new Object[dataRows][2]; // only email & password
		int idx = 0;
		for (int r = firstDataRow; r < totalRows; r++) {
			String email = xlutil.getCellData(sheet, r, 3); // col index 3 = email
			String password = xlutil.getCellData(sheet, r, 5); // col index 5 = password
			data[idx][0] = email;
			data[idx][1] = password;
			idx++;
		}

		// Debug print (optional)
		System.out.println("RegisteredUsers rows=" + data.length);
		return data;
	}
	//data provider 3
	@DataProvider(name = "SearchData")
	public Object[][] getSearchData() throws IOException {
	    String path = "F:\\CapstoneProject\\nopCommerceProject\\testData\\BillindAddressData.xlsx"; 
	    ExcelUtility xlutil = new ExcelUtility(path);

	    String sheet = "Sheet2"; // 🔹 make sure you create a sheet named "Search" in Excel
	    int totalRows = xlutil.getRowCount(sheet);
	    int firstDataRow = 1; // row 0 = header
	    int dataRows = totalRows - firstDataRow;

	    Object[][] data = new Object[dataRows][1]; // only productName column

	    int idx = 0;
	    for (int r = firstDataRow; r < totalRows; r++) {
	        String productName = xlutil.getCellData(sheet, r, 0); // 1st col = product name
	        data[idx][0] = productName;
	        idx++;
	    }

	    return data;
	}


// DataProvider4
	 @DataProvider(name = "CheckoutData")
	    public Object[][] getCheckoutData() throws IOException {
	        // update path as per your project location
	        String path = "F:\\CapstoneProject\\nopCommerceProject\\testData\\BillindAddressData.xlsx";
	        ExcelUtility xlutil = new ExcelUtility(path);

	        String sheet = "Sheet1"; // ensure you have a sheet named "Checkout"
	        int totalRows = xlutil.getRowCount(sheet); // actual count (including header)
	        int headerRowIndex = 0;
	        int totalCols = xlutil.getCellCount(sheet, headerRowIndex);

	        int firstDataRow = 1; // data starts at row index 1 (row 0 = header)
	        int dataRows = totalRows - firstDataRow;
	        if (dataRows <= 0) {
	            throw new RuntimeException("No data rows found in sheet: " + sheet + " (totalRows=" + totalRows + ")");
	        }

	        Object[][] data = new Object[dataRows][totalCols];
	        int idx = 0;
	        for (int r = firstDataRow; r < totalRows; r++) {
	            for (int c = 0; c < totalCols; c++) {
	                data[idx][c] = xlutil.getCellData(sheet, r, c);
	            }
	            idx++;
	        }
	        return data;
	    }

}

// DataProvider3

// DataProvider....
