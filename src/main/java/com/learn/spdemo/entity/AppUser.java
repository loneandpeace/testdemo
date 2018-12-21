package com.learn.spdemo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Column
    @NotBlank(message = "密码不能为空")
    private String password;

    @Column
    @NotBlank(message = "用户邮箱不能为空")
    @Email
    private String email;

}
