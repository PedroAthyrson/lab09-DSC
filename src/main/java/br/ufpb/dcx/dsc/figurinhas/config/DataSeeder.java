package br.ufpb.dcx.dsc.figurinhas.config;

import br.ufpb.dcx.dsc.figurinhas.models.User;
import br.ufpb.dcx.dsc.figurinhas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("admin@figurinhas.com") == null) {
            User admin = new User();
            admin.setNome("Administrador");
            admin.setEmail("admin@figurinhas.com");
            admin.setPassword(passwordEncoder.encode("admin1234"));

            userRepository.save(admin);
            System.out.println("Utilizador administrador criado com sucesso!");
        } else {
            System.out.println("Utilizador administrador já existe.");
        }
    }
}