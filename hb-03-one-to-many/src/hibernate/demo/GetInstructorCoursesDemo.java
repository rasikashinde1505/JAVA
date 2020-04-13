package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Instructor.class)

						.addAnnotatedClass(InstructorDetail.class)

						.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create student object
			// start transaction
			session.beginTransaction();
              
			//get the instructor from db
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor:" + tempInstructor);
			
		   //get courses for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
