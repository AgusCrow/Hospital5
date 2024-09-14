package crudhospital.hospital5;

import DAO.Medico.Medico;
import DAO.Medico.MedicoDAO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate.*;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu (JdbcTemplate jdbcTemplate, MedicoDAO medicoDAO) {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    private EntityManager entityManager;
    MedicoDAO medicoDAO = new MedicoDAO(entityManager);

    @Autowired
    public Menu(JdbcTemplate jdbcTemplate, MedicoDAO medicoDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.medicoDAO = medicoDAO;
    }

    public void mostrarMenu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Listar médicos");
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                List<Medico> medicos = medicoDAO.buscarTodos();
                imprimirMedicos(medicos);
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    private void imprimirMedicos(List<Medico> medicos) {
        for (Medico medico : medicos) {
            System.out.println(medico.getNombre());
        }
    }
}