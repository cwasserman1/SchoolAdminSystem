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
	public Course displayCourseInfo(String courseId) {
		boolean isFound = false;
		for(Course i: CourseData.getAllCourses()) {
			if(i.getCourseId().equals(courseId)) {
				isFound = true;
				return i;
			}
		}
		return new Course("not found","not found","not found","not found","not found",0);
	}

	@Override
	public void registerStudent(String username, String password, String fname, String lname) {
		CourseData.addStudent(username,password,fname,lname);
	}

	@Override
	public void Exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Course> viewALlCourses() {
		return CourseData.getAllCourses();		
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
