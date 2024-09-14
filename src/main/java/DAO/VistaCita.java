package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.Instant;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "VistaCitas")
public class VistaCita {
    @EmbeddedId
    private VistaCitaId id;

    @Column(name = "fecha_hora", nullable = false)
    private Instant fechaHora;

}