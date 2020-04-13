package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			
			Instructor tempInstructor = new Instructor("hritik","roshan","hritik@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.hritik.com", "luv 2 dance");

			// Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			// start transaction
			session.beginTransaction();

			// save the instructor
			// note: this will also save the details object
			// because of CascadeType.ALL
			System.out.println("saving instructor:" + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
