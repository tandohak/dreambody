package com.dreambody.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/*
 *   @author 홍윤표
 *   @description JWT 인증요청을 위한 jwt Request Entity
 *   @date 2020.06.16 10:19:09
 */

@Getter
@Setter
@Data
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;
}