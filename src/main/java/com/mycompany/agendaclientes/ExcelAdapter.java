package com.mycompany.agendaclientes;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HP
 */
public class ExcelAdapter implements DataAgenda {

    private ExcelService excelService;
    private InputStream inputStream;

    public ExcelAdapter(ExcelService excelService, InputStream inputStream) {
        this.excelService = excelService;
        this.inputStream = inputStream;
    }

    @Override
    public List<Persona> obtenerDatos() {
        try {
            XSSFWorkbook workbook = excelService.crearWorkbook(inputStream);
            XSSFSheet sheet = excelService.obtenerPrimeraHoja(workbook);
            List<Persona> personas = excelService.leerPersonasDesdeHoja(sheet);
            workbook.close();
            return personas;
        } catch (IOException e) {
            throw new RuntimeException("Error al obtener datos desde Excel: " + e.getMessage(), e);
        }
    }

    @Override
    public void mostrarDatos(List<Persona> personas) {
        System.out.println("\n--- DATOS DEL EXCEL ---");
        if (personas.isEmpty()) {
            System.out.println("No hay personas en el archivo Excel.");
            return;
        }
        for (Persona p : personas) {
            System.out.println("  • " + p);
        }
    }

}
