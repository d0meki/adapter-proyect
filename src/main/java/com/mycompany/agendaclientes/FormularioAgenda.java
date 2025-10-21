package com.mycompany.agendaclientes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class FormularioAgenda implements DataAgenda {

    private List<Persona> personasFormulario;

    public FormularioAgenda() {
        this.personasFormulario = new ArrayList<>();
    }

    @Override
    public List<Persona> obtenerDatos() {
        return personasFormulario;
    }

    @Override
    public void mostrarDatos(List<Persona> personas) {
        System.out.println("\n--- DATOS DEL FORMULARIO ---");
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas en el formulario.");
            return;
        }
        for (Persona p : personas) {
            System.out.println("  • " + p);
        }
    }

    public void agregarPersona(String nombre, String apellido, int edad) {
        Persona p = new Persona(nombre, apellido, edad);
        personasFormulario.add(p);
        System.out.println(" Persona agregada desde formulario: " + nombre + " " + apellido);
    }
}
