package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Degree degree;
	
	@OneToOne(mappedBy = "professor")//need to point which variable is with @JoinColumn
	@ToString.Exclude
	private Course course;
	
	public Professor(String inputName, String inputSurname, Degree inputDegree)
	{
		setName(inputName);
		setSurname(inputSurname);
		setDegree(inputDegree);
	}
}