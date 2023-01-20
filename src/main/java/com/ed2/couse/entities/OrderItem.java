package com.ed2.couse.entities;

import com.ed2.couse.entities.pk.orderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    public static final long serialVersionUID = 1L;

    @EmbeddedId
    private orderItemPK id = new orderItemPK();
    private Integer quantify;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantify, Double price) {
        this.quantify = quantify;
        this.price = price;
        id.setOrder(order);
        id.setProduct(product);
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }



    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantify() {
        return quantify;
    }

    public void setQuantify(Integer quantify) {
        this.quantify = quantify;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
