package com.gobierno.backend.models;


import com.gobierno.backend.models.enums.EstadoProyecto;
import com.gobierno.backend.models.enums.Prioridad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Proyectos")
@Data // Lombok genera getters, setters, equals, hashCode, toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Genera el patrón Builder para la clase
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyecto;

    @Column(name = "Nombre_Proyecto", nullable = false, length = 100)
    private String nombreProyecto;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Fecha_Inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "Fecha_Estimada_Fin")
    @Temporal(TemporalType.DATE)
    private Date fechaEstimadaFin;

    @Column(name = "Presupuesto", precision = 15, scale = 2)
    private BigDecimal presupuesto;

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado_Proyecto", nullable = false)
    private EstadoProyecto estadoProyecto;

    @ManyToOne
    @JoinColumn(name = "ID_Gerente")
    private Usuario gerente;

    @Enumerated(EnumType.STRING)
    @Column(name = "Prioridad", nullable = false)
    private Prioridad prioridad;
}
