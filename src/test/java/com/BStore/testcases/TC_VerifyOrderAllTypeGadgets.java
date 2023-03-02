package com.BStore.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BStore.pageobjects.cartPage;
import com.BStore.pageobjects.phonesPage;
import com.BStore.pageobjects.placeOrderPage;
import com.BStore.pageobjects.productPage;
import com.BStore.pageobjects.purchaseCompletePage;
import com.BStore.pageobjects.welcomePage;

public class TC_VerifyOrderAllTypeGadgets extends BaseClass
{
	@Test
	public void orderPhones() throws Exception
	{
		logger.info("\n\n**********************************TestCase: orderPhones -> START********************************\n ");

		//1. Open URL(Using Baseclass Setup method)
		SoftAssert sf = new SoftAssert();

		//2. Login with valid username and password
		

		welcomePage wpg = new welcomePage(getDriver());

		//3. Click on the categories
		wpg.clickOnCategories();
		logger.info("Click on categories - opened");

		//4. Click on the phone
		wpg.clickOnPhones();
		logger.info("Click on phones - opened");

		phonesPage ppg = new phonesPage(getDriver());

		//5. Click any phone, e.g., Iphone6
		ppg.clickOnIphone6();
		logger.info("Iphone6 is selected");

		productPage propg = new productPage(getDriver());

		//6. Click on the Add to cart button
		propg.clickOnAddToCart();
		logger.info("Click on AddToCart done");
		alertIsPresent(5);
		getDriver().switchTo().alert().accept();
		logger.info("Click the Ok on alert");

		//7. Click on the cart
		wpg.clickOnCart();
		logger.info("Click on the cart");


		cartPage cpg = new cartPage(getDriver());

		Thread.sleep(1000);

		//8. Verify the added product title, i.e., phones
		if(cpg.getProductList1().contains("Iphone 6 32gb"))
		{
			sf.assertTrue(true, "Assert Passed");
			logger.info("Product name matched: verified!");
		}
		else
		{
			sf.assertTrue(false, " Assert Failed");
			logger.info("Product name not matched!");
			captureScreenShot(getDriver(), "orderPhones_name");
		}

		//9. Verify the added product price
		if (cpg.getProductList1().contains("790"))
		{
			sf.assertTrue(true, "Assert Passed");
			logger.info("Product price matched: verified!");
		}
		else
		{
			sf.assertTrue(false, "Asset Failed");
			logger.info("Product price not matched!");
			captureScreenShot(getDriver(), "orderPhones_price");
		}

		//10. Click on the Place order
		cpg.clickOnPlaceOrder();
		logger.info("Click on the Place Order");

		placeOrderPage plp = new placeOrderPage(getDriver());

		//11. Enter the details
		plp.enterName("Suraj");
		logger.info("Name is entered");

		plp.enterCountry("India");
		logger.info("Country is entered");

		plp.enterCity("Delhi");
		logger.info("City is entered");

		plp.enterCreditCard("456764528679");
		logger.info("CreditCard is entered");

		plp.enterMonth("Febraruy");
		logger.info("Month is entered");

		plp.enterYear("2022");
		logger.info("Year is entered");

		plp.clickOnPurchase();

		purchaseCompletePage pcpg = new purchaseCompletePage(getDriver());

		//12. Click Ok button
		pcpg.clickOnOk();
		logger.info("Ok button clicked: Purchase completed -> Test Step Complete");

		sf.assertAll();
		logger.info("\n\n**********************************TestCase: orderPhones -> ENDS********************************\n ");
	}









}
