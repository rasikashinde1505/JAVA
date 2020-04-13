package hibernet.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	// annotation the class entity and map to db table

	// define the fields

	// annotate the class dp column

	// create constructor

	// create getter setter

	// generate tiString method

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtubeChannelString;

	@Column(name = "hobby")
	private String hobby;

	//add new field for instructor
	//getter and setter methods
	@OneToOne(mappedBy = "instructorDetail",
			cascade= {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })//
	private Instructor instructor;
	
	//
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public InstructorDetail() {

	}

	public InstructorDetail(String youtubeChannelString, String hobby) {
		this.youtubeChannelString = youtubeChannelString;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannelString() {
		return youtubeChannelString;
	}

	public void setYoutubeChannelString(String youtubeChannelString) {
		this.youtubeChannelString = youtubeChannelString;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "instructorDetail [id=" + id + ", youtubeChannelString=" + youtubeChannelString + ", hobby=" + hobby
				+ "]";
	}

}
