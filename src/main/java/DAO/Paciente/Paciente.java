package DAO.Paciente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Lob
    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Nationalized
    @Lob
    @Column(name = "genero", nullable = false)
    private String genero;

    @Nationalized
    @Lob
    @Column(name = "direccion")
    private String direccion;

    @Nationalized
    @Lob
    @Column(name = "telefono")
    private String telefono;

    @Nationalized
    @Lob
    @Column(name = "numero_seguro_medico")
    private String numeroSeguroMedico;

    @Nationalized
    @Lob
    @Column(name = "historial_medico")
    private String historialMedico;

    @Nationalized
    @Lob
    @Column(name = "alergias")
    private String alergias;

    @Nationalized
    @Lob
    @Column(name = "tipo_sangre")
    private String tipoSangre;

}