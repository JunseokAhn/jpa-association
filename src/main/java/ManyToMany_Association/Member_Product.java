package ManyToMany_Association;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member_Product {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member5 member;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int count;
    private int price;
    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member5 getMember() {
        return member;
    }

    public void setMember(Member5 member) {
        this.member = member;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
