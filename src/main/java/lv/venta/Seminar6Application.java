package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class Seminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar6Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testModel(IProfessorRepo profRepo, IStudentRepo studRepo, 
			ICourseRepo courRepo, IGradeRepo grRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professor p1 = new Professor("Karina", "Skirmante", Degree.mg );
				Professor p2 = new Professor("Estere", "Vitola", Degree.mg);
				Professor p3 = new Professor("Karlis", "Immers", Degree.mg);
				
				profRepo.saveAll(Arrays.asList(p1, p2, p3));
				
				Student st1 = new Student("John", "Green");
				Student st2 = new Student("Paul", "Blue");
				studRepo.saveAll(Arrays.asList(st1, st2));
				
				Course c1 = new Course("JAVA Programming", 6, p1);
				Course c2 = new Course("Web technologies", 6, p3);
				Course c3 = new Course("Datu structures and algorithms", 3, p2, p1);
				Course c4 = new Course("Operating Systems", 3, p3);
				courRepo.saveAll(Arrays.asList(c1, c2, c3, c4));
				
				p1.addCourse(c1);
				p1.addCourse(c3);
				p2.addCourse(c3);
				p3.addCourse(c2);
				p3.addCourse(c4);
				profRepo.saveAll(Arrays.asList(p1, p2, p3));
				
				
				
				Grade g1 = new Grade(4, st1, c1);//4 -> John Green -> JAVA
				Grade g2 = new Grade(7, st1, c2);//7 -> John Green -> Web technologies
				Grade g3 = new Grade(9, st2, c2);//9 -> Paul Blue  -> Web technologies
				Grade g4 = new Grade(10, st2, c3);//10 -> Paul Blue -> Data Structures
				grRepo.saveAll(Arrays.asList(g1, g2, g3, g4));
				
			}
		};
	}

}