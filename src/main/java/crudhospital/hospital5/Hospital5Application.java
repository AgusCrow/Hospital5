package crudhospital.hospital5;

import DAO.Medico.MedicoDAO;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class Hospital5Application {



    public static void main(String[] args) {
        SpringApplication.run(Hospital5Application.class, args);

        JdbcTemplate jdbcTemplate = new JdbcTemplate();  // Assuming you have a JdbcTemplate instance
        EntityManager entityManager = null;  // Assuming you have an EntityManager instance
        MedicoDAO medicoDAO = new MedicoDAO(entityManager);        // Assuming you have a MedicoDAO instance

        Menu menu = new Menu(jdbcTemplate, medicoDAO);
        menu.mostrarMenu();
    }



}
