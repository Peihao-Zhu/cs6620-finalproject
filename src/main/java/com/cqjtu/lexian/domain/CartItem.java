package com.cqjtu.lexian.domain;

import javax.persistence.*;

/**
 * CartItem 购物车商品项实体
 *
 * @author suwen
 */
@Entity
@Table(name = "cartitem")
public class CartItem {
  @Column(name = "cartitem_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int cartItemId;

  @ManyToOne
  @JoinColumn(name = "goods_id")
  private Goods goods;

  @ManyToOne
  @JoinColumn(name = "cart_id")
  private Cart cart;

  @Column(name = "num")
  private int num;

  @Column(name = "selected")
  private int selected;

  public int getCartItemId() {
    return cartItemId;
  }

  public void setCartItemId(int cartItemId) {
    this.cartItemId = cartItemId;
  }

  public Goods getGoods() {
    return goods;
  }

  public void setGoods(Goods goods) {
    this.goods = goods;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getSelected() {
    return selected;
  }

  public void setSelected(int selected) {
    this.selected = selected;
  }
}
