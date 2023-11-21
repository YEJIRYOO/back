package com.sbb.flexrate.service;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.dto.CreditCreateRequestDto;
import com.sbb.flexrate.dto.CreditInfoDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.member.MemberRepository;
import com.sbb.flexrate.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional//단일 트랜잭션_ 예외 발생 시 작업 롤백
public class CreditService {
    private final CreditRepository creditRepository;
    private final MemberRepository memberRepository;

/*

    //memberId로 해당 member의 credit 정보 반환
    public Credit findMyCredit(Long memberId){
        Optional<Member> member=memberRepository.findById(memberId);
        if(member.isPresent()){
            return member.get().getCredit();
        }
        else throw new DataNotFoundException("Member not found");
    }

 */
    //credit 수정
    public void updateCredit(Long memberId,CreditCreateRequestDto creditDto){
        Optional<Member> member=memberRepository.findById(memberId);
        if(member.isPresent()){
            Optional<Credit> optionalCredit=creditRepository.findByMemberId(memberId);
            if(optionalCredit.isPresent()){
                Credit credit=optionalCredit.get();
                credit.setExisting_credit_score(creditDto.getExisting_credit_score());
                credit.setExisting_credit_score(creditDto.getExisting_credit_score());
                credit.setYearly_income(creditDto.getYearly_income());
                credit.setCompany_month(creditDto.getCompany_month());
                credit.setLoan_cnt(creditDto.getLoan_cnt());
                credit.setLoan_amount(creditDto.getLoan_amount());
                credit.setDebt_rate(creditDto.getDebt_rate());
                creditRepository.save(credit);
            }else {//member의 credit조회 실패
                System.out.println(memberId);
                throw new DataNotFoundException("해당 Member의 Credit 조회 실패");
            }
        }else {//member조회 실패
            throw new DataNotFoundException("Member 조회 실패");
        }
    }

    public CreditInfoDto getCreditInfo(Long memberId){
        Optional<Member> member=memberRepository.findById(memberId);
        if(member.isPresent()){
            Credit credit=member.get().getCredit();;
            return CreditInfoDto.from(credit);
        }else throw new DataNotFoundException("Member 조회 실패");
    }
}