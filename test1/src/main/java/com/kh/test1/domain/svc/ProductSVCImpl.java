package com.kh.test1.domain.svc;

import com.kh.test1.domain.Product;
import com.kh.test1.domain.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSVCImpl implements ProductSVC{

  private final ProductDAO productDAO;
  /**
   * 등록
   *
   * @param product 등록된 상품
   * @return 등록된 상품
   */
  @Override
  public Product save(Product product) {
    return productDAO.save(product);
  }

  /**
   * 조회
   *
   * @param productId 조회할 상품 아이디
   * @return 조회 상품
   */
  @Override
  public Product findById(Long productId) {
    return productDAO.findById(productId);
  }

  /**
   * 수정
   *
   * @param productId 수정할 상품 아이디
   * @param product   수정 상품
   */
  @Override
  public void update(Long productId, Product product) {
    productDAO.update(productId, product);
  }

  /**
   * 삭제
   *
   * @param productId 삭제할 상품 아이디
   */
  @Override
  public void del(Long productId) {
    productDAO.del(productId);
  }

  /**
   * 목록
   *
   * @return 전체 상품
   */
  @Override
  public List<Product> all() {
    return productDAO.all();
  }
}
