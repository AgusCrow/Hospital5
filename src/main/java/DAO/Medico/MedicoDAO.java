package DAO.Medico;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicoDAO {

    private final EntityManager entityManager;


    public MedicoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // List all medicos
    public List<Medico> buscarTodos() {
        return entityManager.createQuery("SELECT m FROM Medico m", Medico.class).getResultList();
    }

    // Get a single medico by ID
    public Medico buscarPorId(Long id) {
        return entityManager.find(Medico.class, id);
    }

    // Create a new medico
    public void guardar(Medico medico) {
        entityManager.persist(medico);
    }

    // Update an existing medico
    public void editar(Medico medico) {
        entityManager.merge(medico);
    }

    // Delete a single medico by ID
    public void eliminar(Long id) {
        Medico medico = buscarPorId(id);
        if (medico != null) {
            entityManager.remove(medico);
        }
    }
}