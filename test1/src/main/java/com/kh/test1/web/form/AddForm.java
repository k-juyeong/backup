package com.kh.test1.web.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AddForm {
  private String pname;  // PNAME	VARCHAR2(30 BYTE)	Yes		2
  private Integer quantity; //QUANTITY	NUMBER(10,0)	Yes		3
  private Integer price;   // PRICE	NUMBER(10,0)	Yes		4

}
