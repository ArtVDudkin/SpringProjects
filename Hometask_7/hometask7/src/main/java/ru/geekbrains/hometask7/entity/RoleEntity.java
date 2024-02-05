package ru.geekbrains.hometask7.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
@Schema(name = "Роль")
public class RoleEntity {

    public static long sequence = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;

    @Column(name = "role")
    private final String role;

    public RoleEntity() {
        this.id = sequence++;
        this.role = null;
    }

    public RoleEntity(String role) {
        this.id = sequence++;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @JsonCreator
    public RoleEntity(long id, String role) {
        this.id = sequence++;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }

}
