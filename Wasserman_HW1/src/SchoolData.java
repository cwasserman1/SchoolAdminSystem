import java.util.ArrayList;

public class SchoolData {
	private ArrayList<Course> allCourses;
	private ArrayList<User> allUsers;
	private ArrayList<Student> allStudents;
	public SchoolData() {
		
		this.allCourses = allCourses;
		this.allUsers = allUsers;
		this.allStudents = allStudents;
	}
	public ArrayList<Course> getAllCourses() {
		return allCourses;
	}
	public ArrayList<User> getAllUsers() {
		return allUsers;
	}
	public ArrayList<Student> getAllStudents() {
		return allStudents;
	}
	public void addStudent(String username, String password, String fname, String lname) {
		allStudents.add(new Student(username,password,fname,lname));
	}
	public void addCourse(String courseName, String courseId, String courseInstructor, String sectionNumber, String location, int maxReg) {
		allCourses.add(new Course(courseName,courseId,courseInstructor,sectionNumber,location,maxReg));
	}
}
