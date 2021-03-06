package com.dreambody.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/*
 *   @author 홍윤표
 *   @description 구글인증 테스트용 User 엔티티.
 *   @date 2020.06.16 15:25:46
 */
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Email
    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    @Column(columnDefinition = "boolean default false")
    private Boolean answeredQuestion;

    private String profileImage;

    // Getters and Setters (Omitted for brevity)
}