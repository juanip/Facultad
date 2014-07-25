package pruebas;

import java.io.IOException;


public class Main {

	public static void main(String[] args) {
			
		HttpsRequests https = new HttpsRequests();
		
		try {
			String json = https.sendGet("https://api.instagram.com/v1/media/popular?client_id=dc0f359d97414bd298a52efdbd79c80c");
			System.out.println(json);
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

}
