package com.asi.exo01.service;



import java.io.IOException;

//import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.asi.exo01.model.User;
//import com.asi.exo01.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
//	private final UserRepository uRepository;

	public AuthService() {

	}
	
	public User register(User u) throws ParseException, IOException {
		
		String URL_CREATE_USER = "http://localhost:8080/users";


		RestTemplate restTemplate = new RestTemplate();

		// Data attached to the request.
		HttpEntity<User> requestBody = new HttpEntity<>(u);

		// Send request with POST method.
		ResponseEntity<User> result 
		     = restTemplate.postForEntity(URL_CREATE_USER, requestBody, User.class);

		System.out.println("Status code:" + result.getStatusCode());

		// Code = 200.
		if (result.getStatusCode() == HttpStatus.OK) {
			User e = result.getBody();
			return e;
		}
		return null;
		 
		 
		 
//	        // add request parameter, form parameters
//	        List<NameValuePair> urlParameters = new ArrayList<>();
//	        urlParameters.add(new BasicNameValuePair("surname", "abc"));
//	        urlParameters.add(new BasicNameValuePair("name", "123"));
//	        urlParameters.add(new BasicNameValuePair("pwd", "secret"));
//
//	        post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//	        try (CloseableHttpClient httpClient = HttpClients.createDefault();
//	             CloseableHttpResponse response = httpClient.execute(post)) {
//
////	            System.out.println(EntityUtils.toString(response.getEntity()));
//	            System.out.println("dvg"+response.getEntity());
//	            return "13";
//	            //return EntityUtils.toString(response.getEntity());
//	        }
//	        return "ff";

//		if (uRepository.findBySurname(u.getSurname()) == null){
//			uRepository.save(u);
//			return u;
//		}
//		throw new UserExistException();
		
	}
	
	//TODO ON FAIT UN GET DE USER BY USERNAME PUIS ON COMPARE ICI
	public Integer login(User u) {
		String URL_CREATE_USER = "http://localhost:8080/users/{surname}";


		RestTemplate restTemplate = new RestTemplate();

		// Send request with POST method.
		ResponseEntity<User> result 
		     = restTemplate.getForEntity(URL_CREATE_USER, User.class, u.getSurname() );

		System.out.println("Status code:" + result.getStatusCode());

		// Code = 200.
		if (result.getStatusCode() == HttpStatus.OK) {
			User e = result.getBody();
			if(e.getPwd().equals(u.getPwd())) {
				return e.getId();	
			}
			return -1;
		}
		return null;
		
	}
}
