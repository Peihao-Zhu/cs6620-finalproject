package com.cqjtu.lexian.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Category 商品大类实体
 *
 * @author suwen
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "category_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int categoryId;

  @ManyToOne(
      targetEntity = Catalog.class,
      cascade = {CascadeType.MERGE},
      optional = false,
      fetch = FetchType.LAZY)
  @JoinColumn(name = "catalog_id")
  private Catalog catalog;

  @Column(name = "name")
  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private List<Goods> goods;

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public Catalog getCatalog() {
    return catalog;
  }

  public void setCatalog(Catalog catalog) {
    this.catalog = catalog;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Goods> getGoods() {
    return goods;
  }

  public void setGoods(List<Goods> goods) {
    this.goods = goods;
  }
}
