package spring.core.order;

import spring.core.discount.DiscountPolicy;
//import spring.core.discount.FixDiscountPolicy;
//import spring.core.discount.RateDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;

    // *** DIP 위반 -> 인터페이스와 구체클래스 모두 의존하는 상황
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // *** OCP 위반 -> 객체를 코드에서 직접 갈아끼우는 순간 위반!!
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }


}
