package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)


				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();
// get instructor by primary key / id
			int theId=13;
			Instructor tempInstructor = session.get(Instructor.class,  theId);
			
			System.out.println("found instructor Detail"+tempInstructor);
			//delete the instructor
			if(tempInstructor != null) {
				System.out.println("deleting tempInstructor details: " + tempInstructor);
				
				//also delete associated details object bcz we have used cascade type here
				//need to remove the connection between instructor and instructor detail to delete the info od instructor
				
				session.delete(tempInstructor);
			}
			

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
