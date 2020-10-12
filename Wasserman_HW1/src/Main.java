import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	
	static boolean isAdmin;
	static CourseData myData;
	static boolean isStudent;
	private static Admin myAdmin;
	private static Student currentStudent;
	private static String adminUsername;
	private static String adminPassword;
	public static boolean goBack;
	public static boolean isRunning;
	public static void main(String[] args) {
		adminUsername = "Admin";
		adminPassword = "Admin001";
		CourseData.main();
		goBack = false;
		myData = new CourseData();
		isRunning = true;
		
		myAdmin = new Admin("Admin","Admin001","Mr","Admin");
//		ArrayList<String[]> myCourses;
//		try {
//		myCourses= readCSV();
//		for(int k = 0; k <myCourses.size();k++) {
//				String courseName = myCourses.get(k)[0];
//				String courseId = myCourses.get(k)[1]; 
//				String courseInstructor = myCourses.get(k)[2];
//				String sectionNumber = myCourses.get(k)[3];
//				String location = myCourses.get(k)[4];
//				int maxReg = Integer.parseInt(myCourses.get(k)[5]);
//				myAdmin.createCourse(courseName, courseId, courseInstructor, sectionNumber, location, maxReg);
//				
//		}
//		try {
//			saveObject(CourseData.getAllCourses(), "serialCourses");
//			}catch(Exception e) {
//				System.out.println(e);
//			}
//			
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		ArrayList<Course> csvCourses = new ArrayList<Course>();
	try {
		 FileInputStream fis = new FileInputStream("myfile");
         ObjectInputStream ois = new ObjectInputStream(fis);
         csvCourses = (ArrayList<Course>) ois.readObject();
         ois.close();
         fis.close();
         for(Course i : csvCourses) {
        	 
         }
         }catch(Exception e){
		System.out.println(e);
	}
		do {
		login();
		}while(isRunning);
		
		
		
		
	}
	public static void saveObject(Object e,String fileName) throws IOException{
		FileOutputStream fos= new FileOutputStream(fileName);
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        oos.writeObject(e);
        oos.close();
        fos.close();

	}
//	public static Object loadObject(String fileName) throws IOException{
//		try {
//		FileInputStream fis = new FileInputStream(fileName);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Object e =  ois.readObject();
//        ois.close();
//        fis.close();}catch (ClassNotFoundException a){
//        	System.out.println("File not found");
//        	a.printStackTrace();
//       }
//		return e;
//		}
//	
		
		public static ArrayList<String[]> readCSV() throws IOException {
		   
		    String file =  "/Users/colewasserman/Desktop/CS102 Data Structures/UniversityCourses.csv";
		    ArrayList<String[]> content = new ArrayList<>();
		    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		        String line = "";
		        while ((line = br.readLine()) != null) {
		            content.add(line.split(","));
		        }
		    } catch (FileNotFoundException e) {
		      System.out.println("File Not Found");
		    }
		    return content;
		}

    
	
	public static void login(){
		Scanner sc = new Scanner(System.in);
		String resp;
		String enteredUsername, enteredPassword;
		System.out.println("1. Admin Login");
		System.out.println("2.  Student Login");
		System.out.println("3.  Exit");
		resp = sc.nextLine();
		switch(Integer.parseInt(resp)) {
		case 1:
			System.out.println("Username: ");
			enteredUsername = sc.nextLine();
			System.out.println("Password: ");
			
			enteredPassword = sc.nextLine();
			if(enteredUsername.equals(adminUsername) && enteredPassword.equals(adminPassword)) {
				System.out.println("You are logged in as: Admin");
				adminUI();	
			} else {
				System.out.println("The username or password you entered is wrong");
				login();
			}
			
		case 2:
			System.out.println("Username: ");
			enteredUsername = sc.nextLine();
			System.out.println("Password: ");
			enteredPassword = sc.nextLine();
			for(Student i: CourseData.getAllStudents()) {
				if(i.getUsername().equals(enteredUsername)&&i.getPassword().equals(enteredPassword)){
					System.out.println("You are logged in as "+ i.getFname()+" "+i.getLname());
					//currentStudent = new Student(i.getUsername(),i.getPassword(),i.getFname(),i.getLname());
					currentStudent = CourseData.getAllStudents().get(CourseData.getAllStudents().indexOf(i));
		
					studentUI();
					
				} else {
					System.out.println("The username or password you entered is wrong");
					studentUI();
				}
			}
			
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
			login();
		}
		
	}while(isAdmin);}
	
	public static void studentUI() {
		do {
		System.out.println("1. View all courses \n 2. View open courses \n 3. Enroll in a course \n 4. Drop a course \n 5. View your current schedule");
		Scanner scannerA = new Scanner(System.in);
		String rep = scannerA.nextLine();
		isStudent = true;
		
		try {
		switch(Integer.parseInt(rep.trim())) {
			case 1:
				currentStudent.viewAllCourses();
				break;
			case 2:
				currentStudent.viewAllCourses();
				break;
			case 3:
				System.out.println("Enter the following information of the course you could like to enroll in: ");
				
				System.out.println("Course ID: ");
				String enrollID = scannerA.nextLine().trim();	
				
				System.out.println("Section Number ");
				String enrollSectionNumber = scannerA.nextLine().trim();
				currentStudent.enrollInCourse(enrollID, enrollSectionNumber);
				break;
			case 4:
				System.out.println("Enter the following information of the course you could like to drop: ");
				
				System.out.println("Course ID: ");
				String dropID = scannerA.nextLine().trim();	
				
				System.out.println("Section Number ");
				String dropSectionNumber = scannerA.nextLine().trim();
				currentStudent.dropCourse(dropID, dropSectionNumber);
				break;
				
			case 5:
				currentStudent.viewCurrentReg();
				break;
				
		
		}
		}catch(Exception e) {
			System.out.println("Invalid input... Please enter integers only");
			studentUI();
		}}while(isStudent);
	}}



 