package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;
import hibernet.demo.entity.Review;

public class DeleteCreateCoursesReviewDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(Review.class)

						.addAnnotatedClass(InstructorDetail.class)

						.buildSessionFactory();
		// create sessions
		Session session = factory.getCurrentSession();

		try {
			// create student object
			// start transaction
			session.beginTransaction();
            
			//get the course
			int theId = 10;
			Course tempCourse= session.get(Course.class, theId);
			
			//print the course 
			System.out.println(tempCourse);
			
			//delete the course and review
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
