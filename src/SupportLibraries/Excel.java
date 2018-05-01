package SupportLibraries;


import java.io.FileInputStream;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import Execute.RUN;


public class Excel extends RUN {
	
	private static HSSFSheet ExcelWSheet;
	 
	private static HSSFWorkbook ExcelWBook;

	private static HSSFCell Cell;

	
	
	
	public static String Exceldata(String SheetName,String ColumnName) throws Exception{
		
		FileInputStream ExcelFile = new FileInputStream("src//TestCases//"+Excel1+".xls");
		
		//File inputworkbook=new File("src//TestCases//"+Excel1+".xls");
		
		try{
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
		
		/*Workbook w;
		w=Workbook.getWorkbook(inputworkbook);
		Sheet sheet=w.getSheet(SheetName);*/
		int ii=0;
		
		while(ii<=ExcelWSheet.getRow(0).getLastCellNum())
		{
			Cell = ExcelWSheet.getRow(0).getCell(ii);
			String runtime_ColName=Cell.getStringCellValue();
			if(runtime_ColName.equals(ColumnName))
			{
				break;
			}
			if (ii==ExcelWSheet.getRow(0).getLastCellNum())
			{
				Report.fail(ColumnName+" column does not exist in sheet "+SheetName, "Nill", "Nill");
			}
			ii++;
		}
		int jj=0;
		while(jj<=ExcelWSheet.getLastRowNum())
		{
			Cell = ExcelWSheet.getRow(jj).getCell(0);
			String runtime_TCID=Cell.getStringCellValue();
			if(runtime_TCID.equals(TCID1))
			{
				break;
			}
			if (jj==ExcelWSheet.getLastRowNum())
			{
				Report.fail(TCID1+" Testcase Id does not exist in sheet "+SheetName, "Nill", "Nill");
			}
			jj++;
		}
		String value=ExcelWSheet.getRow(jj).getCell(ii).getStringCellValue();
		ExcelWBook.close();
		return value;
		} catch (Exception e){

			throw (e);

		}
		
	}

}
