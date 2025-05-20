package com.controleusuario.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id
    private Long id;

    private String name;

    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Enum {
        ADMIN(1L, "admin"),
        USER(2L, "user");

        Enum(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        private final String name;
        private final Long id;

        public Role get(){
            return new Role(id, name);
        };

    }

}
