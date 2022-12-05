package spring.core.discount;

import org.springframework.stereotype.Component;
import spring.core.member.Grade;
import spring.core.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountPerent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return price * discountPerent / 100;
        else
            return 0;    }
}
