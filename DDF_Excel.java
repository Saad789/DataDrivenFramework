import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class DDF_Excel{

	public static void main(String[] args) throws BiffException, IOException, InterruptedException {
		File f = new File("D:\\Selenium - Saad(C06)\\Test Data\\Adactin_TestData.xls");
        Workbook wb = Workbook.getWorkbook(f);
        Sheet ws = wb.getSheet("Login");
        int X = ws.getRows();
        
        for(int i = 1; i <= X; i++) {
        	String Username = ws.getCell(0,i).getContents();
        	String Password = ws.getCell(1,i).getContents();
        	String Location = ws.getCell(2,i).getContents();
        	String Hotels  = ws.getCell(3,i).getContents();
        	String RoomType = ws.getCell(4,i).getContents();
        	String CheckIn = ws.getCell(5,i).getContents();
        	String CheckOut = ws.getCell(6,i).getContents();
        	String FirstName = ws.getCell(7,i).getContents();
        	String LastName = ws.getCell(8,i).getContents();
        	String Address = ws.getCell(9,i).getContents();
        	String CardNo = ws.getCell(10,i).getContents();
        	String CardType = ws.getCell(11,i).getContents();
        	String ExpiryMonth = ws.getCell(12,i).getContents();
        	String ExpiryYear = ws.getCell(13,i).getContents();
        	String CVV = ws.getCell(14,i).getContents();
        	
        	
        	System.setProperty("webdriver.chrome.driver","D:\\Selenium - Saad(C06)\\Browser Drivers\\chrome\\chromedriver.exe");
        	WebDriver driver = new ChromeDriver();
        	driver.get("http://adactin.com/HotelAppBuild2/");
        	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(Username);
        	Thread.sleep(5000);
        	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Password);
        	Thread.sleep(5000);
        	driver.findElement(By.xpath(".//*[@id='login']")).click();
        	Thread.sleep(2000);
        	
        	new Select(driver.findElement(By.xpath(".//*[@id='location']"))).selectByVisibleText(Location);
        	Thread.sleep(5000);
        	new Select(driver.findElement(By.xpath(".//*[@id='hotels']"))).selectByVisibleText(Hotels);
        	Thread.sleep(5000);
        	new Select(driver.findElement(By.xpath(".//*[@id='room_type']"))).selectByVisibleText(RoomType);
        	driver.findElement(By.xpath(".//*[@id='datepick_in']")).sendKeys(CheckIn);
        	driver.findElement(By.xpath(".//*[@id='datepick_out']")).sendKeys(CheckOut);       	
        	driver.findElement(By.xpath(".//*[@id='Submit']")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath(".//*[@id='radiobutton_0']")).click();
        	driver.findElement(By.xpath(".//*[@id='continue']")).click();
        	Thread.sleep(5000);
        	
            driver.findElement(By.xpath(".//*[@id='first_name']")).sendKeys(FirstName);
        	driver.findElement(By.xpath(".//*[@id='last_name']")).sendKeys(LastName);
        	driver.findElement(By.xpath(".//*[@id='address']")).sendKeys(Address);
        	driver.findElement(By.xpath(".//*[@id='cc_num']")).sendKeys(CardNo);
        	driver.findElement(By.xpath(".//*[@id='cc_type']")).sendKeys(CardType);
        	driver.findElement(By.xpath(".//*[@id='cc_exp_month']")).sendKeys(ExpiryMonth);
        	driver.findElement(By.xpath(".//*[@id='cc_exp_year']")).sendKeys(ExpiryYear);
        	driver.findElement(By.xpath(".//*[@id='cc_cvv']")).sendKeys(CVV);
        	driver.findElement(By.xpath(".//*[@id='book_now']")).click();
        	Thread.sleep(5000);
        	String OrderNo = driver.findElement(By.xpath(".//*[@id='order_no']")).getAttribute("Value");
        	System.out.println("The OrderNumber is " +OrderNo);
        	driver.findElement(By.xpath(".//*[@id='logout']")).click();
        	Thread.sleep(2000);
        	driver.quit();
        }
        
    }
}
