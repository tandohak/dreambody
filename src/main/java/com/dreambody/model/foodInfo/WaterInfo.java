package com.dreambody.model.foodInfo;

import com.dreambody.model.BaseTimeEntity;
import com.dreambody.model.User;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class WaterInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false)
    private int amountWater;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public WaterInfo(LocalDate registrationDate, int amountWater, User user) {
        this.registrationDate = registrationDate;
        this.amountWater = amountWater;
        this.user = user;
    }

    public void updateWater(int amountWater) {
        this.amountWater = amountWater;
    }
}
