package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)

				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create student object
			/*Instructor tempInstructor = new Instructor("Rasika","shinde","aslkfsd@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.gmail.com", "luv 2 code");
*/
			
			Instructor tempInstructor = new Instructor("Gunjan","Kadu","gunjan@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.gunjan.com", "luv 2 learn");

			// Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			// start transaction
			session.beginTransaction();

			// save the instructor
			// note: this will also save the details object
			// bacause of CascadeType.ALL
			System.out.println("saving instructor:" + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
