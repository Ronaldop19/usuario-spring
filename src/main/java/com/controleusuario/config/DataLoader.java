package com.controleusuario.config;

import com.controleusuario.entity.Role;
import com.controleusuario.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        Arrays.stream(Role.Enum.values())
                .forEach(Role -> roleRepository.save(Role.get()));
    }
}
