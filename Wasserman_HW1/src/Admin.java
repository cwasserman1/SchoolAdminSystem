import java.util.*;
public class Admin extends User implements IAdmin{

	public Admin(String username, String password, String fname, String lname) {
		super(username, password, fname, lname);
	}

	@Override
	public void createCourse(String courseName, String courseId, String courseInstructor, String sectionNumber, String location, int maxReg) {

		CourseData.addCourse(courseName, courseId, courseInstructor, sectionNumber, location, maxReg);
	}

	@Override
	public void deleteCourse(String courseId, String sectionNumber) {
		
		CourseData.removeCourse(courseId, sectionNumber);
		
	}

	@Override
	public void editCourse() {
		// TODO Auto-generated method stub
	}

	@Override
	public void displayCourseInfo(String courseId, String sectionNumber) {
		String resp;
		Scanner sc = new Scanner(System.in);
		boolean isFound = false;
		for(Course i: CourseData.getAllCourses()) {
			if(i.getCourseId().equals(courseId)&&i.getSectionNumber().equals(sectionNumber)) {
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
					System.out.println("Location"+i.getLocation()+"\n Max Capacity: "+i.getMaxReg());
					break;
				}
			}
		}
		
	}

	@Override
	public void registerStudent(String username, String password, String fname, String lname) {
		CourseData.addStudent(username,password,fname,lname);
	}

	@Override
	public void Exit () {
		
		
	}

	

	@Override
	public void viewAllFull() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeFull() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sortCourses() {
		// TODO Auto-generated method stub
		
	}
	
}
