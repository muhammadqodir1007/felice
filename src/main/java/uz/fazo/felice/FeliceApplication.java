package uz.fazo.felice;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.fazo.felice.auth.AuthenticationService;
import uz.fazo.felice.auth.RegisterRequest;
import uz.fazo.felice.user.Role;
import uz.fazo.felice.user.User;
import uz.fazo.felice.user.UserRepository;


@SpringBootApplication
@AllArgsConstructor
public class FeliceApplication {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FeliceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminUsername = "lafelice";
            if (!userRepository.existsByUsername(adminUsername)) {
                User admin = User.builder()
                        .role(Role.ADMIN)
                        .username(adminUsername)
                        .password(passwordEncoder.encode("lafelice2024"))
                        .enabled(true)
                        .build();
                userRepository.save(admin);
            }
        };
    }
}
