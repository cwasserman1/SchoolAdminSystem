import java.util.ArrayList;
public class CourseData {
	private static ArrayList<Course> allCourses;
	private static ArrayList<Student> allStudents;
	private static ArrayList<User> allUsers;
	public static String adminUsername;
	public static String adminPassword;
	public static void main(String[] args) {
		allCourses = new ArrayList<Course>();
		allStudents = new ArrayList<Student>();
		allUsers = new ArrayList<User>();
		adminUsername = "Admin";
		adminPassword = "Admin001";
	}
	public static ArrayList<Course> getAllCourses() {
		return allCourses;
	}
	public static ArrayList<User> getAllUsers() {
		return allUsers;
	}
	public static ArrayList<Student> getAllStudents() {
		return allStudents;
	}
	public static void addStudent(String username, String password, String fname, String lname) {
		allStudents.add(new Student(username,password,fname,lname));
	}
	public static void addCourse(String courseName, String courseId, String courseInstructor, String sectionNumber, String location, int maxReg) {
		allCourses.add(new Course(courseName,courseId,courseInstructor,sectionNumber,location,maxReg));
	}
	public static void removeCourse(String courseId, String sectionNumber) {
		for(Course i: CourseData.getAllCourses()) {
			if(i.getCourseId().equals(courseId)) {
				allCourses.remove(CourseData.getAllCourses().indexOf(i));
			}
		}
	}
	
}
