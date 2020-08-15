package com.dreambody.model;

import lombok.*;

import javax.persistence.*;

/**
 *   @author 홍윤표
 *   @description
 *   @date 2020.08.15 13:00:11
 */
@Entity
@Table(name = "blackList")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlackList extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
}
