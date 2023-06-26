package courseTodo;
import java.util.Collection;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
public class CourseProcessor {
	private Collection<Course> courses=new ArrayList();
	private Course course = new Course();
	private DaoInterface<Course, Integer> di = new CourseInDBDao();
	
public Course acceptCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course details");
		System.out.println("Enter course Id = ");
		int id = sc.nextInt();
		System.out.println("Enter Course Title = ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("Enter Course Duration = ");
		int duration = sc.nextInt();
		System.out.println("Enter Course Providers Name = ");
		String provider = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter Course Cost = ");
		int cost = sc.nextInt();
		Course course = new Course(id,title,duration,provider,cost);
		return course;
	}
	
	public void display() {
		for(Course course:courses) {
			System.out.println(course);
		}
	}
	public int putId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course Id = ");
		int id = sc.nextInt();
		return id;
	}
		
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("0.Exit 1.Add new course 2.Get all courses 3.Search course by Id 4.Update course cost by Id 5.Delete course by Id");
			System.out.println("Enter your choice");
			n = sc.nextInt();
			int id;
			switch(n) {
			case 1:course=acceptCourse();
			di.createNew(course);
			break;
			//case 2:courses = di.getAll();
			//courses.stream().forEach((rs)->System.out.println(rs));
			//break;
			case 3:id = putId();
				course=di.getOneById(id);
				System.out.println(course);
			break;
			case 4:id = putId();
				di.update(id);
			break;
			case 5:id = putId();
			di.deleteById(id);
			break;
			case 6:System.exit(0);
			break;
			}
		}while(n!=0);	
	}
}
