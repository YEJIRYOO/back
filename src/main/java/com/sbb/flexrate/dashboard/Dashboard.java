/*
package com.sbb.flexrate.dashboard;

import com.sbb.flexrate.dto.DashboardCreateRequestDto;
import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne(targetEntity = Member.class,fetch = FetchType.LAZY)//지연로딩
    @JoinColumn(name ="member_id")
    private String dashboard;

    @Column
    private Long payment; //납입 금액

    @Column
    private Date payment_date;//납입일

    @Column
    private Float quarterly_interest_rate;//분기 적용 금리

    @Column
    private Date loan_maturity_date;//대출 만기일

    @Column
    private Long remain_loan;//잔여 대출금

    @Column
    private Long paidback_loan;//상환한 대출금

    public static Dashboard from(DashboardCreateRequestDto dashboardDto){
        return Dashboard.builder()
                .payment(dashboardDto.getPayment())
                .payment_date(dashboardDto.getPayment_date())
                .quarterly_interest_rate(dashboardDto.getQuarterly_interest_rate())
                .loan_maturity_date(dashboardDto.getLoan_maturity_date())
                .remain_loan(dashboardDto.getRemain_loan())
                .paidback_loan(dashboardDto.getPaidback_loan())
                .build();
    }
}
*/
