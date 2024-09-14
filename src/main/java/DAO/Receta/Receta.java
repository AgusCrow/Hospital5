package DAO.Receta;

import DAO.Medicamento;
import DAO.Medico.Medico;
import DAO.Paciente.Paciente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "recetas")
public class Receta {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ColumnDefault("getdate()")
    @Column(name = "fecha_creacion")
    private Instant fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    @Nationalized
    @Lob
    @Column(name = "dosis")
    private String dosis;

    @Nationalized
    @Lob
    @Column(name = "frecuencia")
    private String frecuencia;

    @Nationalized
    @Lob
    @Column(name = "duracion_tratamiento")
    private String duracionTratamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}