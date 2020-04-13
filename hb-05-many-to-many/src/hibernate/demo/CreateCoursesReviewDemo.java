package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;
import hibernet.demo.entity.Review;

public class CreateCoursesReviewDemo {

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
            
			//create course
			Course tempCourse= new Course("java software development");
			
			//add some reviews
			tempCourse.addReview(new Review("the course is excellent"));
			tempCourse.addReview(new Review("explained very well"));
			tempCourse.addReview(new Review("worst ever"));

			// save the course.... and leverage the cascade all:
			System.out.println("saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
