package com.ferrovial.accesstodatabricks;



import com.ferrovial.interfaceUI.WebDriverSingleton;
import com.ferrovial.pages.Login;



public class Test_Login {

private static Login login;
private String email;
private String password;

    public Test_Login() {

    this.login = new Login(WebDriverSingleton.getDriver());
}
    
    public void setCredentials(String email, String password) {
        this.email = email;
        this.password = password;
        
    }
    public void doLogIn() throws Exception {


		login.clickOnSignInWithAzureAD();
		login.setEmailAddress(email);
		login.setPassword(password);
		System.out.println("Nice");
		login.clickOnText();
		
		Thread.sleep(60000);
		// verify 
		
       login.isLoginSuccess();

	}
}
