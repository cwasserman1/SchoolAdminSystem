import java.util.*;
public interface IAdmin {
	public void createCourse(String courseName, String courseId, String courseInstructor, String sectionNumber, String location, int maxReg);
	public void deleteCourse(String courseId, String sectionNumber);
	public void editCourse();
	public void registerStudent(String username, String password, String fname, String lname);
	public void Exit();
	public void viewAllFull();
	public void writeFull();
	public void sortCourses();
}
