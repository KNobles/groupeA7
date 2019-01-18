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

	public static List<Student> getStudents(File file) throws IOException, InvalidFormatException 
    {
		sections.add(ad);
		sections.add(ct);
		sections.add(it);
        List<Student> students = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file);
        
        Sheet sheet = workbook.getSheetAt(0);
        
        sheet.forEach(row -> {
            if(row.getRowNum() > 0)
            {
                students.add(new Student().loadFromRow(row, sections));
            }
        });

        workbook.close();
        
        return students;
    }
}


