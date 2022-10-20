package com.kh.test1.web.form;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemForm {
  private Long productId; // PRODUCT_ID	NUMBER(10,0)	No		1
  private String pname;  // PNAME	VARCHAR2(30 BYTE)	Yes		2
  private Integer quantity; //QUANTITY	NUMBER(10,0)	Yes		3
  private Integer price;   // PRICE	NUMBER(10,0)	Yes		4

}
