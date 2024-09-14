package DAO.Medico;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Lob
    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Nationalized
    @Lob
    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Nationalized
    @Lob
    @Column(name = "numero_colegiado", nullable = false)
    private String numeroColegiado;

    @Column(name = "anos_experiencia")
    private Integer anosExperiencia;

    @Nationalized
    @Lob
    @Column(name = "horario_atencion")
    private String horarioAtencion;

    @Nationalized
    @Lob
    @Column(name = "consultorio")
    private String consultorio;

}