/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.agendaclientes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author HP
 */
public class AgendaClienteDemo {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  DEMOSTRACIÓN: PATRÓN ADAPTER - AGENDA DE CLIENTES║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        // Read Excel
//        JFileChooser fileChooser = new JFileChooser();
//
//        int result = fileChooser.showOpenDialog(null);
//
//        if (result == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = fileChooser.getSelectedFile();
//            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
//            ExcelService excelService = new ExcelService();
//            InputStream inputStream = new FileInputStream(selectedFile);
//            DataAgenda excelFileAdapter = new ExcelAdapter(excelService, inputStream);
//            List<Persona> personList = excelFileAdapter.obtenerDatos();
//            System.out.println(personList);
//        } else {
//            System.out.println("No se seleccionó ningún archivo.");
//        }
        // Read Formulario
        FormularioAgenda dataFormulario = new FormularioAgenda();
        dataFormulario.agregarPersona("Juan", "García", 28);
        dataFormulario.agregarPersona("María", "López", 34);
        dataFormulario.agregarPersona("Carlos", "Martínez", 45);
        List<Persona> personList = dataFormulario.obtenerDatos();
        System.out.println(personList);
    }
}
