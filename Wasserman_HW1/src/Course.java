import java.io.Serializable;
import java.util.ArrayList; 
public class Course implements Serializable{
	private String courseName, courseId, courseInstructor, sectionNumber,location;
	private ArrayList<Student> listOfReg;
	private int maxReg, currentReg;
	boolean isFull;
	
	public Course(String courseName, String courseId, String courseInstructor, String sectionNumber, String location, int maxReg) {
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseInstructor = courseInstructor;
		this.sectionNumber = sectionNumber;
		this.location = location;
		this.maxReg = maxReg;
		this.listOfReg = new ArrayList<Student>();
		this.currentReg = 0;
		isFull = false;
		}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseInstructor() {
		return courseInstructor;
	}
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	public String getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(String sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMaxReg() {
		return maxReg;
	}
//	public void setMaxReg(int max) {
//		this.maxReg = max;
//	}
	public ArrayList<Student> getListOfReg() {
		return listOfReg;
	}
	public int getCurrentReg() {
		return currentReg;
	}
	public boolean checkFull() {
		if(currentReg == maxReg) {
			return true;
		}
		return false;
	}
	public boolean addStudent(Student e) { //This method is called when adding a student. Increments currentReg if space is available. Returns true if student was added and false if student was not added.
		
		if(currentReg+1 > maxReg) {
			System.out.println("Unable to add student...Class is full");
			return false;
		}
			System.out.println("Student sucessfully registered in class.");
			listOfReg.add(e);
			currentReg++;
			return true;
		
	}
	
	}

