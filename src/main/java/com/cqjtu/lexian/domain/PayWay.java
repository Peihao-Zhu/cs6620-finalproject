package com.cqjtu.lexian.domain;

import javax.persistence.*;

/**
 * PayWay 支付方式实体
 *
 * @author suwen
 */
@Entity
@Table(name = "payway")
public class PayWay {
  @Column(name = "payway_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int paywayId;

  @Column(name = "name")
  private String name;

  @Column(name = "img")
  private String img;

  public int getPaywayId() {
    return paywayId;
  }

  public void setPaywayId(int paywayId) {
    this.paywayId = paywayId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }
}
