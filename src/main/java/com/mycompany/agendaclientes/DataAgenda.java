package com.mycompany.agendaclientes;

import java.util.List;

public interface DataAgenda {

    List<Persona> obtenerDatos();

    void mostrarDatos(List<Persona> personas);
}
