/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author marki
 */
@Entity
@Table(name = "empleados", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Empleado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombre", nullable = false, length=50)
    private String nombre;
    
    @Column (name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column (name = "salario", nullable = false, check = @CheckConstraint(constraint = "salario > 0"))
    private Double salario;
    
    @Enumerated(EnumType.STRING)
    private TipoEstatus tipo;
    
    @Column (name = "fechaContratacion", nullable = false)
    private LocalDate fechaContratacion;

    public Empleado() {
    }

    public Empleado(String nombre, Double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public Empleado(Long id, String nombre, String email, Double salario, TipoEstatus tipo, LocalDate fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.tipo = tipo;
        this.fechaContratacion = fechaContratacion;
    }

    public Empleado(String nombre, String email, Double salario, TipoEstatus tipo, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.tipo = tipo;
        this.fechaContratacion = fechaContratacion;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public TipoEstatus getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstatus tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String toString() {
        return "\nEmpleado{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", salario=" + salario + ", tipo=" + tipo + ", fechaContratacion=" + fechaContratacion + '}';
    }
    
    
}
