package main.java;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;
import java.io.IOException;

public class MyApp {

		List<Student> studentList = new ArrayList();
		public static List<Student> parseJSOn(String url) throws ParseException {
	        List<Student> studentList = new ArrayList();
	        List<Course> courseList = new ArrayList();
	        Client client = Client.create();
	        WebResource webResource = client.resource(url);

	        ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
	        if (clientResponse.getStatus() != 200) {
	            throw new RuntimeException("Failed"+ clientResponse.toString());
	        }

	        JSONArray jsonArray = (JSONArray) new  JSONParser().parse(clientResponse.getEntity(String.class));

	        Iterator<Object> it = jsonArray.iterator();

	        String firstName;
	        String gender;
	        String email;
	        while (it.hasNext()){
	            JSONObject jsonObject = (JSONObject)it.next();
	            firstName = (String)jsonObject.get("first_name");
	            gender = (String)jsonObject.get("gender");
	            email = (String)jsonObject.get("email");
	            studentList.add(new Student(firstName,gender,email));
	        }

	        return studentList;
	        
	    }
		public void searchName(String first_name) {
			for(Student student: studentList) {
				if(student.getFirst_name().equals(first_name))
					System.out.println("found " + first_name);
			}
		}
		public void searchCourse(String courseNo) {
			for (Course course: courseList) {
				if(course.getCourseNo().equals(courseNo));
					System.out.println("found " + courseNo);
			}
		}
		
		public static void main(String[] args) throws ParseException {

	        List<Student> studentList = parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student.json");
	        for ( Student student: studentList){
	            System.out.println(student.toString());
	        }
		}
	}
