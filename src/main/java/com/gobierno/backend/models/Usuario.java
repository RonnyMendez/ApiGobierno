package com.gobierno.backend.models;

import com.gobierno.backend.models.enums.Estado;
import com.gobierno.backend.models.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Usuarios")
@Data // Genera automáticamente los getters, setters, equals, hashCode y toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Genera el patrón Builder para la clase
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "Correo_Electronico", nullable = false, unique = true, length = 100)
    private String correoElectronico;

    @Enumerated(EnumType.STRING)
    @Column(name = "Rol", nullable = false)
    private Rol rol;

    @Column(name = "Departamento_Area", length = 100)
    private String departamentoArea;

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = false)
    private Estado estado = Estado.ACTIVO;

    @Column(name = "Fecha_Creacion", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date fechaCreacion = new Date(); // Inicializa por defecto con la fecha actual
}