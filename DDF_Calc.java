import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

public class DDF_Calc {

	public static void main(String[] args) throws IOException, InterruptedException, JXLException {
		File f = new File("D:\\Selenium - Saad(C06)\\Test Data\\DDF_TestData.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet ws = wb.getSheet("Calc");
		int X = ws.getRows();
		
		for(int i = 1; i < X; i++) {
			String Input1 = ws.getCell(0,i).getContents();
			String Operator = ws.getCell(1,i).getContents();
			String Input2 = ws.getCell(2,i).getContents();
			
			System.setProperty("webdriver.chrome.driver","D:\\Selenium - Saad(C06)\\Browser Drivers\\chrome\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.way2automation.com/angularjs-protractor/calc/");
            Thread.sleep(3000);
            driver.findElement(By.xpath("html/body/div[3]/div/form/input[1]")).sendKeys(Input1);
            Thread.sleep(3000);
            new Select(driver.findElement(By.xpath("html/body/div[3]/div/form/select"))).selectByVisibleText(Operator);
            Thread.sleep(2000);
            driver.findElement(By.xpath("html/body/div[3]/div/form/input[2]")).sendKeys(Input2);
            Thread.sleep(3000);
            driver.findElement(By.xpath(".//*[@id='gobutton']")).click();
            Thread.sleep(5000);
            String result = driver.findElement(By.xpath("html/body/div[3]/div/form/h2")).getText();
            System.out.println("The Result is " +result);
            Thread.sleep(3000);
            driver.quit();
	}

}
}
