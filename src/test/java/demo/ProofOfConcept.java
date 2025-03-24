package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ProofOfConcept {
	
public static void main(String[] args) {
		
		//Get the webdriver instance driver for chrome
		WebDriver driver = new EdgeDriver();
		
		//Navigate to google.com
		driver.get("https://www.practo.com/");
		
		//Maximise window
		driver.manage().window().maximize();
		
		//Print out the title
		System.out.println("The Browser title is: "+driver.getTitle());
		
		
		
		
		// Locate the homePage location button logo using XPath
        WebElement webLocator = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div/input"));
        webLocator.clear();
        webLocator.sendKeys("Bangalore");
        
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div/input")); // Replace with the actual ID of the next input box
       // Click the next input box to focus on it
         // Type "Hospitals" into the next input box
        try {
        	searchBox.sendKeys("Hospital");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[5]/span[1]/div"));
        dropDown.click();
      

        // Print the src attribute of the Google logo
        //System.out.println("Google Logo Src: " + googleLogo.getAttribute("src"));
        
        
		
//		driver.quit();
	}

}
