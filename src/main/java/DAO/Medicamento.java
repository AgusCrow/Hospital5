package DAO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Lob
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Nationalized
    @Lob
    @Column(name = "presentacion")
    private String presentacion;

    @Nationalized
    @Lob
    @Column(name = "dosis")
    private String dosis;

    @Nationalized
    @Lob
    @Column(name = "indicaciones")
    private String indicaciones;

    @Nationalized
    @Lob
    @Column(name = "contraindicaciones")
    private String contraindicaciones;

}