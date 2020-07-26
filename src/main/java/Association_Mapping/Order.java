package Association_Mapping;

import Oneway_association.Member;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Table(name = "ORDERS")
public class Order {

    @Id @Column(name = "ORDER_ID")
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member3 member;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    private Date OrderDate;
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member3 getMember() {
        return member;
    }

    public void setMember(Member3 member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
