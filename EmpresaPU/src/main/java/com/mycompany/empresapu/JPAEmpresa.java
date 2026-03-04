/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.empresapu;

import daos.EmpleadoDAO;
import entity.Empleado;
import entity.TipoEstatus;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author marki
 */
public class JPAEmpresa {

    public static void main(String[] args) {
        //Crear instancia
        EmpleadoDAO empleadoDao = new EmpleadoDAO();
        
        
        //Insertar algunos empleados de prueba
        Empleado e1 = new Empleado("Marcos Nuñez","marquitos@gmail", 3500.00, TipoEstatus.ACTIVO, LocalDate.of(2026, Month.MARCH, 4));
        Empleado e2 = new Empleado("Jorge Perez", "jorgais@gmail",1500.00,TipoEstatus.ACTIVO, LocalDate.of(2026, Month.MARCH, 4));
        
        empleadoDao.insertar(e1);
        empleadoDao.insertar(e2);
        
        //Listar todos los empleados y mostrar en consola
        System.out.println(empleadoDao.obtenerTodos());
        
        //Modificar un empleado y voler a listar
        Empleado empTemporal = empleadoDao.buscar(1L);
        empTemporal.setNombre("Juancho");
        empleadoDao.actualizar(empTemporal);
        System.out.println(empleadoDao.obtenerTodos());
        
        //Aumentar salario y verificar cambios
        empleadoDao.aumentarSalario(2L, 10.00);
        System.out.println(empleadoDao.obtenerTodos());
        
        //eliminar empleado y verificar
        empleadoDao.eliminar(2L);
        System.out.println(empleadoDao.obtenerTodos());
    }
}
