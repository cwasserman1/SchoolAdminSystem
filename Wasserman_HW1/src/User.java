
public class User {
	protected String username, password, fname, lname;

	public User(String username, String password, String fname, String lname) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}
	public void viewAllCourses() {
		int count = 0;
		for(Course i : CourseData.getAllCourses())
		{
			count++;
			System.out.println("Course"+count);
			System.out.println(" Name: "+i.getCourseName()+"\n ID: "+i.getCourseId()+"\n Instructor: "+i.getCourseInstructor()+ "\n Section Number: "+i.getSectionNumber());
			System.out.println(" Location: "+i.getLocation()+"\n Max Capacity: "+i.getMaxReg());
		}
	
	}
	public void displayCourseInfo(String courseId, String sectionNumber) {
		System.out.println("Hello");
	}
	
	
}
