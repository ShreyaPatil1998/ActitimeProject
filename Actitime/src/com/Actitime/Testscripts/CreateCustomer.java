package com.Actitime.Testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitme.ObjectRepository.HomePage;
import com.Actitme.ObjectRepository.TaskPage;

public class CreateCustomer extends BaseClass{
	
@Test
public void Createcustomer() throws InterruptedException, IOException {
	HomePage hp=new HomePage(driver);
	hp.getTasktab().click();
	TaskPage tp=new TaskPage(driver);
	tp.getAddnewbtn().click();
	tp.getNewcust().click();
	FileLibrary fl=new FileLibrary();
	String customer=fl.readDataExcel("Data",3,1);
	tp.getCustname().sendKeys(customer);
	String description=fl.readDataExcel("Data",3,2);
	tp.getCustdesp().sendKeys(description);
	tp.getCreatebtn().click();
	String expectedresult=customer;
	String actualresult=driver.findElement(By.xpath("//div[.='"+customer+"']")).getText();
	SoftAssert s=new SoftAssert();
	s.assertEquals(actualresult, expectedresult);
	}
}
