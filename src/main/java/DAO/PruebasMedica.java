package DAO;

import DAO.Paciente.Paciente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pruebas_medicas")
public class PruebasMedica {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Lob
    @Column(name = "tipo_prueba", nullable = false)
    private String tipoPrueba;

    @Nationalized
    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Nationalized
    @Lob
    @Column(name = "resultados")
    private String resultados;

    @Column(name = "fecha_realizacion")
    private Instant fechaRealizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}