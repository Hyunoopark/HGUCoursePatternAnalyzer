package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		String[] splitStu = new String[100];
		String[] splitCourse = new String[100];
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		
		
		for(int i = 0; i < lines.length; i++) {
			if(lines[i] != null)
				splitStu[i] = lines[i].split(",")[1].trim();
		}
		
		for(int i = 0; i < lines.length; i++) {
			if(lines[i] != null)
				splitCourse[i] = lines[i].split(",")[2].trim();
		}
	
		students = initiateStudentArrayFromLines(splitStu);
		
		System.out.println("Number of All Students: " + numOfStudents);
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				if(studentExist(students,students[i]) == true)
					System.out.println(students[i].getName());
			}
		}
		
		System.out.println("Number of All Courses: " + numOfCourses);
		
		courses = initiateCourseArrayFromLines(splitCourse);
		
		for(int i = 0; i < courses.length; i++) {
			if(courses[i] != null) {
				if(courseExist(courses,courses[i]) == true)
					System.out.println(courses[i].getCourseName());
			}
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		Student[] student1 = null;
		
		student1 = new Student[lines.length];
		
		for(int i = 0; i < lines.length; i++) {
			if(lines[i] != null)
				student1[i] = new Student(lines[i].trim());
		} 
		
		return student1;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getName() == student.getName()) {
				for(int j = 0; j < i; j++) {
					if(students[i].getName().equals(students[j].getName()))
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		Course[] course1 = null;
		
		course1 = new Course[lines.length];
		
		for(int i = 0; i < lines.length; i++) {
			if(lines[i] != null)
				course1[i] = new Course(lines[i].trim());
		} 
		
		return course1;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		for(int i = 0; i < courses.length; i++) {
			if(courses[i] != null && courses[i].getCourseName() == course.getCourseName()) {
				for(int j = 0; j < i; j++) {
					if(courses[i].getCourseName().equals(courses[j].getCourseName()))
						return false;
				}
				return true;
			}
		}
		return false;
	}

}
