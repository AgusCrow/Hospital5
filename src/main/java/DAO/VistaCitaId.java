package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class VistaCitaId implements java.io.Serializable {
    private static final long serialVersionUID = -9101341567784439128L;
    @Nationalized
    @Lob
    @Column(name = "paciente", nullable = false)
    private String paciente;

    @Nationalized
    @Lob
    @Column(name = "medico", nullable = false)
    private String medico;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VistaCitaId entity = (VistaCitaId) o;
        return Objects.equals(this.paciente, entity.paciente) &&
                Objects.equals(this.medico, entity.medico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paciente, medico);
    }

}