package com.dreambody.model.userInit;

import com.dreambody.model.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : 이병덕
 * @description : 사용자가 초기에 정보 생성 시 선택하는 성별
 * @date : 2020.06.21
 */

@Getter
@NoArgsConstructor
@Table(name ="genders", uniqueConstraints = {
        @UniqueConstraint(columnNames = "gender")
})
@Entity
public class Gender extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1)
    private String gender;



    @Builder
    public Gender (String gender) {
        this.gender = gender;
    }
}
