package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.demo.entity.Course;
import hibernet.demo.entity.Instructor;
import hibernet.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			int theId=14;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
		   //create some courses
			Course tempCourse1 = new Course("Guitar");
			Course tempCourse2 = new Course("Craft");
			Course tempCourse3 = new Course("sing");
			Course tempCourse4 = new Course("dance");
			Course tempCourse5 = new Course("cook");

			//add courses
			tempInstructor.add(tempCourse1);
	        tempInstructor.add(tempCourse2);
	        tempInstructor.add(tempCourse3);
	        tempInstructor.add(tempCourse4);
	        tempInstructor.add(tempCourse5);

	        //save the courses
	        session.save(tempCourse1);
	        session.save(tempCourse2);
	        session.save(tempCourse3);
	        session.save(tempCourse4);
	        session.save(tempCourse5);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
