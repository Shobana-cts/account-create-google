package bussinessComponents;

import pageObjects.GoogleAccountCreation;

public class GoogleAccountCreation_BC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GoogleAccountCreation googleAccountCreation = new GoogleAccountCreation();
		try {
			googleAccountCreation.googleLaunchBrowser();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
