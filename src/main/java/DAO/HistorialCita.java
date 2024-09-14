package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "historial_citas")
public class HistorialCita {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cita_id")
    private Integer citaId;

    @Nationalized
    @Column(name = "accion", length = 50)
    private String accion;

    @Column(name = "fecha")
    private Instant fecha;

}