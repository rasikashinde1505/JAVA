package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
              
			//get the course
			int theId=11;
	       Course tempCourse = session.get(Course.class, theId);
						
		   //delete the course
			System.out.println(" Deleting Courses: " + tempCourse);
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
