import java.util.List;
import java.util.ArrayList;
public class Student extends User implements IStudent{
	private List<Course> currentCourses;
	public Student(String username, String password, String fname, String lname) {
		super(username, password, fname, lname);
		currentCourses = new ArrayList<Course>();
	}

	@Override
	public void viewAllCourses() {
		System.out.println(CourseData.getAllCourses());
	}

	@Override
	public void viewOpenCourses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enrollInCourse() {
		// TODO Auto-generated method stub
		
	}
   
	@Override
	public void dropCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewCurrentReg() {
		
	}

	@Override
	public void Exit() {
		// TODO Auto-generated method stub
		
	}

}
