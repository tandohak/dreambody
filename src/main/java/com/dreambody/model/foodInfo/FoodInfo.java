package com.dreambody.model.foodInfo;

import com.dreambody.model.BaseTimeEntity;

import javax.persistence.*;

/**
 * @author : 이병덕
 * @description : 사용자가 저장한 식품정보
 * @date : 2020.07.08
 */

@Entity
public class FoodInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String foodCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float protein;

    @Column(nullable = false)
    private Float fat;

    @Column(nullable = false)
    private Float carbohydrate;
}
