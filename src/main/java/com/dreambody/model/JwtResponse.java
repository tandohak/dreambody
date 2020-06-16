package com.dreambody.model;

import lombok.Data;

import java.io.Serializable;

/*
 *   @author 홍윤표
 *   @description JWT 인증 결과 리턴을 위한 엔터티
 *   @date 2020.06.16 10:19:09
 */

@Data
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

}
