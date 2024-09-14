package DAO;

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
@Table(name = "historias_clinicas")
public class HistoriasClinica {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ColumnDefault("getdate()")
    @Column(name = "fecha_creacion")
    private Instant fechaCreacion;

    @Nationalized
    @Lob
    @Column(name = "notas_medico")
    private String notasMedico;

    @Nationalized
    @Lob
    @Column(name = "diagnosticos")
    private String diagnosticos;

    @Nationalized
    @Lob
    @Column(name = "resultados_pruebas")
    private String resultadosPruebas;

    @Nationalized
    @Lob
    @Column(name = "prescripciones")
    private String prescripciones;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}