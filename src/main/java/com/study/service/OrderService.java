package com.study.service;


import com.study.domain.Delivery;
import com.study.domain.Member;
import com.study.domain.Order;
import com.study.domain.OrderItem;
import com.study.domain.item.Item;
import com.study.repository.ItemRepository;
import com.study.repository.MemberRepository;
import com.study.repository.OrderRepository;
import com.study.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문상품 생성
        OrderItem orderItem = OrderItem.crateOrderItem(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);
        orderRepository.save(order);

        return order.getId();
    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order =  orderRepository.findOne(orderId);
        //주문 취소
        order.cancel();
    }

    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAllByCriteria(orderSearch);
    }
}
