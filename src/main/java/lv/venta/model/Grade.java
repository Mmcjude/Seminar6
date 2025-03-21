package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")//MySql - grade_table
@Entity
public class Grade {
	@Column(name = "GId")
	@Setter(value = AccessLevel.NONE)//will remove setter for id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gId;
	
	@Column(name = "GrValue")
	@Min(1)
	@Max(10)
	private int grValue;
	
	private Student student;
	
	
	@ManyToOne
	@JoinColumn(name = "CId")//this will create a new column as FK
	private Course course;
	
	
	public Grade(int inputGrValue, Student inputStudent, Course inputCourse)
	{
		setGrValue(inputGrValue);
		setStudent(inputStudent);
		setCourse(inputCourse);
	}
}