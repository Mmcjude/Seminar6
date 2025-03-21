package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")//MySql - professor_table
@Entity
public class Course {
	@Column(name = "CId")
	@Setter(value = AccessLevel.NONE)//will remove setter for id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cId;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z ()]{4,40}")
	@Column(name = "Title")
	private String title;
	
	@Min(1)
	@Max(30)
	@Column(name = "CreditPoints")
	private int creditPoints;
	
	@OneToOne
	@JoinColumn(name = "PId")//this will create a new column as FK
	private Professor professor;
	
	
	
	
	
	 public Course(String inputTitle, int inputCreditPoints, Professor inputProfessor)
	    {
	    	setTitle(inputTitle);
	    	setCreditPoints(inputCreditPoints);
	    	setProfessor(inputProfessor);
	    }

}