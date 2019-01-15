package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReport;
	private String note;
	private String date;
	
	private User author; //auteur de la note : directeur ou relais
	private Student student;
	
	
}
