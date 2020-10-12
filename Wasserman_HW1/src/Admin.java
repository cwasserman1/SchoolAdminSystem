import java.util.*;
import java.io.*;
public class Admin extends User implements IAdmin{

	public Admin(String username, String password, String fname, String lname) {
		super(username, password, fname, lname);
	}

	@Override
	public void createCourse() {
		Scanner response = new Scanner(System.in);
		boolean isMakingCourse = true;
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
			response.close();
			
			switch(Integer.parseInt(conf)) {
			
			case 1:
				
				try {
				CourseData.addCourse(courseName, courseId, courseInstructor, sectionNumber, location, maxReg);
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
		
	}

	@Override
	public void deleteCourse() {
		Scanner response = new Scanner(System.in);
		String targetID,targetSectionNumber;
		System.out.println("Delete a Course: \n Course ID");
		targetID = response.nextLine();
		System.out.println("Course Section Number");
		targetSectionNumber = response.nextLine(); //Write code in case that course is not in allCourses
		
		CourseData.removeCourse(targetID, targetSectionNumber);
		
	}

	@Override
	public void editCourse() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Select the course details you would lke to edit");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void displayCourseInfo() {
		Scanner response = new Scanner(System.in);
		System.out.println("View a Course: \n Course ID");
		String courseID = response.nextLine();
		System.out.println("Course Section Number");
		String sectionNumber = response.nextLine();
		String resp;
		Scanner sc = new Scanner(System.in);
		boolean isFound = false;
		for(Course i: CourseData.getAllCourses()) {
			if(i.getCourseId().equals(courseID)&&i.getSectionNumber().equals(sectionNumber)) {
				System.out.println("1. List of students enrolled in class");
				
				System.out.println("2. General Class info");
				
				resp = sc.nextLine();
				switch(Integer.parseInt(resp)) {
				case 1:
					for(Student k: i.getListOfReg()) {
						System.out.print(k.getFname()+" "+k.getLname()+",");
					}
					break;
				case 2:
					System.out.println("Name: "+i.getCourseName()+"\nID:"+i.getCourseId()+"\n Instructor: "+i.getCourseInstructor()+ "\n  Section Number: "+i.getSectionNumber());
					System.out.println("Location"+i.getLocation()+"\n Max Capacity: "+i.getMaxReg()+"Current number enrolled: "+ i.getCurrentReg());
					break;
				}
			}
		}
		
	}

	@Override
	public void registerStudent() {
		Scanner response = new Scanner(System.in);
		System.out.println("Register a student into the System");
		System.out.println("First Name");
		String studentFName  = response.nextLine();
		System.out.println("Last Name");
		String studentLName  = response.nextLine();
		System.out.println("User Name");
		String studentUName  = response.nextLine();
		System.out.println("Password");
		String studentPWord  = response.nextLine();
		CourseData.addStudent(studentUName,studentPWord,studentFName,studentLName);
		
	}

	
	
	

	@Override
	public void viewAllFull() {
		for(Course i: CourseData.getAllCourses()) {
			if(i.checkFull()==true) {
				System.out.println("Name: "+i.getCourseName()+"\nID:"+i.getCourseId()+"\n Instructor: "+i.getCourseInstructor()+ "\n  Section Number: "+i.getSectionNumber());
				System.out.println("Location"+i.getLocation()+"\n Max Capacity: "+i.getMaxReg()+"Current number enrolled: "+ i.getCurrentReg());
			}
		}
		
	}

	@Override
	public void writeFull() {
		Scanner response = new Scanner(System.in);
		System.out.println("What would you like the file to be called?");
		String fileName = response.nextLine();
		try {
			FileWriter writer = new FileWriter(fileName);
			for(Course i: CourseData.getAllCourses()) {
				if(i.checkFull()==true) {
					writer.write("Name: "+i.getCourseName()+"\nID:"+i.getCourseId()+"\n Instructor: "+i.getCourseInstructor()+ "\n  Section Number: "+i.getSectionNumber());
					writer.write("Location"+i.getLocation()+"\n Max Capacity: "+i.getMaxReg()+"Current number enrolled: "+ i.getCurrentReg());
					
				}
				
			}
			writer.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}


	@Override
	public void sortCourses() {
	ArrayList<Course> allCoursesCopy = new ArrayList<Course>();
	allCoursesCopy.addAll(CourseData.getAllCourses());
	Collections.sort(allCoursesCopy,(c1, c2) -> c1.getCurrentReg()-c2.getCurrentReg());
	int count = 0;
	for(Course i : allCoursesCopy)
	{
		count++;
		System.out.println("Course"+count);
		System.out.println(" Name: "+i.getCourseName()+"\n ID: "+i.getCourseId()+"\n Instructor: "+i.getCourseInstructor()+ "\n Section Number: "+i.getSectionNumber());
		System.out.println(" Location: "+i.getLocation()+"\n Max Capacity: "+i.getMaxReg()+"\n Current capacity: "+ i.getCurrentReg());
	}

}
}