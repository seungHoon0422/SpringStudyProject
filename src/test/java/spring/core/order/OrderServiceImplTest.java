package spring.core.order;

import org.junit.jupiter.api.Test;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        FixDiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, fixDiscountPolicy);


    }

}