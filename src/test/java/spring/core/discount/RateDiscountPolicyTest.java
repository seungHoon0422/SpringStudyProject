package spring.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core.member.Grade;
import spring.core.member.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다")
    void vip_o() {

        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        int discount = rateDiscountPolicy.discount(memberVIP, 10000);

        assertThat(discount).isEqualTo(1000);


    }


    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {

        Member memberVIP = new Member(1L, "memberBASIC", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(memberVIP, 10000);

        assertThat(discount).isEqualTo(0);

    }



}