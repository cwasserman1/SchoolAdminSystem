import java.util.List;
import java.util.ArrayList;
public class Student extends User implements IStudent{
	private List<Course> schedule;
	public Student(String username, String password, String fname, String lname) {
		super(username, password, fname, lname);
		schedule = new ArrayList<Course>();
	}

	

	@Override
	public void viewOpenCourses() {
		int count = 0;
		for(Course i : CourseData.getAllCourses())
		{
			if(i.checkFull()==false) {
			count++;
			System.out.println("Course"+count);
			System.out.println(" Name: "+i.getCourseName()+"\n ID: "+i.getCourseId()+"\n Instructor: "+i.getCourseInstructor()+ "\n Section Number: "+i.getSectionNumber());
			System.out.println(" Location: "+i.getLocation()+"\n Max Capacity: "+i.getMaxReg());}
		}
		
	}

	@Override
	public void enrollInCourse(String courseId, String sectionNumber) {
		for(int i = 0; i<CourseData.getAllCourses().size();i++) {
			if(CourseData.getAllCourses().get(i).getCourseId().equals(courseId)&&CourseData.getAllCourses().get(i).getSectionNumber().equals(sectionNumber)) {
				CourseData.getAllCourses().get(i).addStudent(new Student(username,password,fname,lname));
				schedule.add(CourseData.getAllCourses().get(i));
			}
		}
		
	}
   
	@Override
	public void dropCourse(String courseId, String sectionNumber) {
		for(Course i: schedule) {
			if(i.getCourseId().equals(courseId)&&i.getSectionNumber().equals(sectionNumber)) {
				schedule.remove(schedule.indexOf(i));
			}
		}
		
	}

	@Override
	public void viewCurrentReg() {
		int count = 0;
		for(Course i : schedule)
		{
			count++;
			System.out.println("Course"+count);
			System.out.println(" Name: "+i.getCourseName()+"\n ID: "+i.getCourseId()+"\n Instructor: "+i.getCourseInstructor()+ "\n Section Number: "+i.getSectionNumber());
			System.out.println(" Location: "+i.getLocation()+"\n Max Capacity: "+i.getMaxReg());
		}
	}

	@Override
	public void Exit() {
		// TODO Auto-generated method stub
		
	}

}
