package com.mycompany.agendaclientes;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HP
 */
public class ExcelService {

    public XSSFWorkbook crearWorkbook(InputStream inputStream) throws IOException {
        return new XSSFWorkbook(inputStream);
    }

    public XSSFSheet obtenerPrimeraHoja(XSSFWorkbook workbook) {
        return workbook.getSheetAt(0);
    }

    public List<Persona> leerPersonasDesdeHoja(XSSFSheet sheet) {
        List<Persona> personas = new ArrayList<>();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { // Empieza en 1 para saltar encabezado
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }

            Persona persona = construirPersonaDesdeFila(row);
            personas.add(persona);
        }

        return personas;
    }

    public Persona construirPersonaDesdeFila(Row row) {
        int cell = row.getFirstCellNum();
        Persona persona = new Persona();

        persona.setNombre(obtenerValorCeldaComoString(row, cell));
        persona.setApellido(obtenerValorCeldaComoString(row, ++cell));
        persona.setEdad((int) row.getCell(++cell).getNumericCellValue());

        return persona;
    }

    public String obtenerValorCeldaComoString(Row row, int cellIndex) {
        if (row.getCell(cellIndex) == null) {
            return "";
        }
        return String.valueOf(row.getCell(cellIndex));
    }
}
