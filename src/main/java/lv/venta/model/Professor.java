package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.model.enums.Degree;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable")//MySql - professor_table
@Entity
public class Professor {
	@Column(name = "PId")
	@Setter(value = AccessLevel.NONE)//will remove setter for id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	@Column(name = "Name")
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,15}")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,30}")
	private String surname;
	
	@NotNull
	@Column(name = "Degree")
	@Enumerated(EnumType.STRING)
	private Degree degree;
	
	@ManyToMany
	@JoinTable(name = "CourseProfessorTable", 
	joinColumns = @JoinColumn(name = "PId"), 
	inverseJoinColumns = @JoinColumn(name = "CId"))
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<Course>();
	
	public Professor(String inputName, String inputSurname, Degree inputDegree)
	{
		setName(inputName);
		setSurname(inputSurname);
		setDegree(inputDegree);
	}
	
	public void addCourse(Course inputCourse) {
		if(inputCourse != null && !courses.contains(inputCourse))
		{
			courses.add(inputCourse);
		}
	}
	
	//TODO create removeCourse function
	
}