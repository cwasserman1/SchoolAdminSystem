import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	
	static boolean isAdmin;
	static CourseData myData;
	private static Admin myAdmin;
	public static boolean goBack;
	public static boolean isRunning;
	public static void main(String[] args) {
		CourseData.main();
		goBack = false;
		myData = new CourseData();
		isRunning = true;
		
		myAdmin = new Admin("Admin","Admin001","Mr","Admin");
		System.out.println("Admin is "+ myAdmin);
		do {
		login();
		}while(isRunning);
		
		//
	}
	public static void login(){
		Scanner sc = new Scanner(System.in);
		String resp;
		
		System.out.println("1. Admin Login");
		System.out.println("2.  Student Login");
		System.out.println("2.  Exit");
		resp = sc.nextLine();
		
		switch(Integer.parseInt(resp)) {
		case 1:
			adminUI();
		case 2:
			studentUI();
		case 3:
			isRunning = false;
		}

	}
//	public static ArrayList<Course> getAllCourses() {
//		return allCourses;
//	}
	public static void adminUI() {
		Scanner scanner = new Scanner(System.in);
		isAdmin = true;
		do {
		boolean isMakingCourse = false;
		System.out.println("Options: \n 1. Create Course \n 2. Delete a course \n 3. Edit a course \n 4. Display info for a particular course \n 5. Register a student into the System \n 6. View all courses \n 7. View all full courses \n 8. Save a file of currently full courses \n 9. Sort Courses based on number of registered Students \n 10. Exit");
		int resp = Integer.parseInt(scanner.nextLine());
		Scanner response = new Scanner(System.in);
		
		switch(resp) {
		
		case 1:
			do {
			isMakingCourse = true;
			String courseName, courseId, courseInstructor,sectionNumber,location, myString;
			int maxReg;
			System.out.println("Course Name: ");
			courseName = response.nextLine();
			
			
			System.out.println("Course Id: ");
			courseId = response.nextLine();
		
			
			System.out.println("Course Instructor: ");
			courseInstructor = response.nextLine();
			
			System.out.println("Location: ");
			location = response.nextLine();
			
			
			System.out.println("Section Number: ");
			sectionNumber = response.nextLine();
			

			System.out.println("Maximum Capacity: ");
			String aString = response.nextLine();
			maxReg = Integer.parseInt(aString);
			
			System.out.println("Confirm add Course");

			System.out.println("1. Confirm \n 2. Restart course adding process \n 3. Exit ");
			
			String conf = response.nextLine().trim();
			
			switch(Integer.parseInt(conf)) {
			
			case 1:
				
				try {
				myAdmin.createCourse(courseName, courseId, courseInstructor, sectionNumber, location, maxReg);
				System.out.println("Course Created");}catch(Exception e) {
					System.out.println(e);
				}
				isMakingCourse = false;
				break;
			case 2:
				continue;
			case 3:
				isMakingCourse = false;
				break;
			}
			}while(isMakingCourse);
			break;
		case 2:
			String targetID,targetSectionNumber;
			System.out.println("Delete a Course: \n Course ID");
			targetID = response.nextLine();
			System.out.println("Course Section Number");
			targetSectionNumber = response.nextLine(); //Write code in case that course is not in allCourses
			myAdmin.deleteCourse(targetID, targetSectionNumber);
			break;
		case 3:
			break;
		case 4:
			System.out.println("View a Course: \n Course ID");
			targetID = response.nextLine();
			System.out.println("Course Section Number");
			targetSectionNumber = response.nextLine();
			myAdmin.displayCourseInfo(targetID, targetSectionNumber);
			
			break;
		case 5:
			System.out.println("Register a student into the System");
			System.out.println("First Name");
			String studentFName  = response.nextLine();
			System.out.println("Last Name");
			String studentLName  = response.nextLine();
			System.out.println("User Name");
			String studentUName  = response.nextLine();
			System.out.println("Password");
			String studentPWord  = response.nextLine();
			myAdmin.registerStudent(studentUName, studentPWord, studentFName, studentLName);
			break;
		case 6:
			myAdmin.viewAllCourses();
			break;
		case 7:
			for(Course i: CourseData.getAllCourses()) {
				if(i.checkFull()==true) {
					//System.out.println(myAdmin.displayCourseInfo(i.getCourseId(), i.getSectionNumber()))
				}
			}
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			isAdmin = false;
		}
		
	}while(isAdmin);}
	public static void studentUI() {
		
	}}



 