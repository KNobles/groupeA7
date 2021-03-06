package be.helha.aemt.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import be.helha.aemt.entities.Section;
import be.helha.aemt.entities.Student;

public abstract class StudentReader {
	
	private static Section ad = new Section("Assistant de direction", "AD");
	private static Section ct = new Section("Comptabilit�", "CT");
	private static Section it = new Section("Informatique de gestion", "IG");
	private static List<Section> sections = new ArrayList<>();

	/**
	 * 
	 * @param file = fichier o� sont contenus les �tudiants � r�cup�rer
	 * @return une liste d'�tudiants issue du fichier plac� en param�tre
	 * @throws IOException en cas d'erreur de fichier
	 * @throws InvalidFormatException en cas d'erreur de format
	 */
	public static List<Student> getStudents(File file) throws IOException, InvalidFormatException 
    {
		sections.add(ad);
		sections.add(ct);
		sections.add(it);
        List<Student> students = new ArrayList<>(); //on cr�e la liste qu'on va renvoyer apr�s la lecture du fichier
        Workbook workbook = WorkbookFactory.create(file);
        
        Sheet sheet = workbook.getSheetAt(0);
        
        sheet.forEach(row -> { //on parcourt les lignes du fichier 
            if(row.getRowNum() > 0) //tant qu'il y a des donn�es
            {
                students.add(new Student().loadFromRow(row, sections)); //ajout � la liste des �tudiants
            }
        });

        workbook.close(); //fermeture du flux
        
        return students; //on renvoit la liste d'�tudiants remplie par le contenu du fichier
    }
}


