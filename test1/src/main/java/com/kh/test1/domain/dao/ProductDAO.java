package com.kh.test1.domain.dao;

import com.kh.test1.domain.Product;

import java.util.List;

public interface ProductDAO {

  /**
   * 등록
   * @param product 등록된 상품
   * @return 등록된 상품
   */
  Product save(Product product);

  /**
   * 조회
   * @param productId 조회할 상품 아이디
   * @return 조회 상품
   */
  Product findById(Long productId);

  /**
   * 수정
   * @param productId 수정할 상품 아이디
   * @param product 수정 상품
   */
  void update(Long productId, Product product);

  /**
   * 삭제
   * @param productId 삭제할 상품 아이디
   */
  void del(Long productId);

  /**
   * 목록
   * @return 전체 상품
   */
  List<Product> all();

  /**
   * 상품아이디 생성
   * @return
   */
  Long getProductId();
}
