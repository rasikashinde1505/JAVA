package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;
import hibernet.demo.entity.Review;
import hibernet.demo.entity.student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(Review.class)
						.addAnnotatedClass(student.class)
						.addAnnotatedClass(InstructorDetail.class)

						.buildSessionFactory();
		// create sessions
		Session session = factory.getCurrentSession();

		try {
			// create student object
			// start transaction
			session.beginTransaction();
            
			//create course
			Course tempCourse= new Course("java software development");
			Course tempCourse1= new Course("C++ software development");
			Course tempCourse2= new Course("Python software development");
			Course tempCourse3= new Course("C# software development");

			// save the course.... and leverage the cascade all:
			System.out.println("saving the course");
			System.out.println(tempCourse);
			session.save(tempCourse);
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);

			System.out.println("saved the courses");
			//create student
			student tempStudent1= new student("rasika","shinde","rasika@gmail.com");
			student tempStudent2= new student("gunjan","kadu","gunjan@gmail.com");

			//add students to course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			
			//save the student
			System.out.println("saving the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
System.out.println("saved students:"+tempCourse.getStudents());
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
