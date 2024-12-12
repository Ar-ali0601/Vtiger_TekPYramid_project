package Comcast.Crm.ProductTest;


import org.testng.annotations.Test;

import Com.Crm.generic.BaseUtility.BaseUtility;
import Comcast.Crm.ObjRepo.Products.CreateNewProductsPage;
import Comcast.Crm.ObjRepo.Products.ProductsInfoPage;
import Comcast.Crm.ObjRepo.Products.ProductsPage;
import Comcast.Crm.ObjectRepository.HomePage;

public class ProductTest extends BaseUtility {
	
	String productName;
	@Test
	public void createProductTest() throws Throwable {
		productName = exLib.getDataFromExcelFile("Sheet3", 1, 2) + javaLib.getRandomNumber();

		HomePage hp= new HomePage(driver);
		ProductsPage pp= new ProductsPage(driver);
		CreateNewProductsPage cnpp= new CreateNewProductsPage(driver);
		ProductsInfoPage pip=new ProductsInfoPage(driver);


		hp.getProductLink().click();
		Thread.sleep(2300);
		pp.getCreateProducts().click();
		
		cnpp.getProductName().sendKeys(productName);
		cnpp.getSaveBtn().click();
		pip.viewHeaderMasg(productName);
	}
		
	}

