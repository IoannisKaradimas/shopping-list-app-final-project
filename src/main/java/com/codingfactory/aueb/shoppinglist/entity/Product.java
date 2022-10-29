package com.codingfactory.aueb.shoppinglist.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name = "QUANTITY")
    private Integer quantity;
}
