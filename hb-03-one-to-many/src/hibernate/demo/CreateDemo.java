package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)

				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create student object
			

			Instructor tempInstructor = new Instructor("Gunjan", "Kadu", "gunjan@gmail.com");
			Instructor tempInstructor1 = new Instructor("rasika", "shinde", "rasika@gmail.com");
			Instructor tempInstructor2 = new Instructor("mrunal", "shinde", "mrunal@gmail.com");
			Instructor tempInstructor3 = new Instructor("mohit", "satpute", "mohit@gmail.com");
			Instructor tempInstructor4 = new Instructor("shubham", "lodhi", "shubham@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.gunjan.com", "luv 2 learn");
			InstructorDetail tempInstructorDetail1 = new InstructorDetail("http://www.rasika.com", "luv 2 dance");
			InstructorDetail tempInstructorDetail2 = new InstructorDetail("http://www.mrunal.com", "luv 2 swim");
			InstructorDetail tempInstructorDetail3 = new InstructorDetail("http://www.mohit.com", "luv 2 play");
			InstructorDetail tempInstructorDetail4 = new InstructorDetail("http://www.shubham.com", "luv 2 sleep");

			// Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			tempInstructor1.setInstructorDetail(tempInstructorDetail1);
			tempInstructor2.setInstructorDetail(tempInstructorDetail2);
			tempInstructor3.setInstructorDetail(tempInstructorDetail3);
			tempInstructor4.setInstructorDetail(tempInstructorDetail4);

			// start transaction
			session.beginTransaction();

			// save the instructor
			// note: this will also save the details object
			// bacause of CascadeType.ALL
			System.out.println("saving instructor:" + tempInstructor);
			session.save(tempInstructor);
			session.save(tempInstructor1);
			session.save(tempInstructor2);
			session.save(tempInstructor3);
			session.save(tempInstructor4);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
