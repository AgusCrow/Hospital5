package DAO.Citas;

import DAO.Medico.Medico;
import DAO.Paciente.Paciente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "citas_medicas")
public class CitasMedica {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha_hora", nullable = false)
    private Instant fechaHora;

    @Nationalized
    @Lob
    @Column(name = "motivo")
    private String motivo;

    @Nationalized
    @Column(name = "estado", length = 50)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

}