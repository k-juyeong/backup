package com.kh.test1.web.product;

import com.kh.test1.domain.Product;
import com.kh.test1.domain.svc.ProductSVC;
import com.kh.test1.web.form.AddForm;
import com.kh.test1.web.form.EditForm;
import com.kh.test1.web.form.ItemForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductSVC productSVC;

  // 등록화면
  @GetMapping("/add")
  public String addForm() {
    return "product/addForm";
  }

  // 등록처리
  @PostMapping("/add")
  public String add(AddForm addForm) {

    Product product = new Product();
    product.setPname(addForm.getPname());
    product.setQuantity(addForm.getQuantity());
    product.setPrice(addForm.getPrice());

    Product savedProduct = productSVC.save(product);

    return "redirect:/products/" + savedProduct.getProductId();
  }

  // 조회
  @GetMapping("/{pid}")
  public String findByProductId(
      @PathVariable("pid") Long pid,
      Model model
  ) {

    Product findedProduct = productSVC.findById(pid);

    ItemForm itemForm = new ItemForm();
    itemForm.setProductId(findedProduct.getProductId());
    itemForm.setPname(findedProduct.getPname());
    itemForm.setQuantity(findedProduct.getQuantity());
    itemForm.setPrice(findedProduct.getPrice());

    model.addAttribute("itemForm", itemForm);

    return "product/itemForm";
  }

  // 수정
  @GetMapping("/{pid}/edit")
  public String editForm(
      @PathVariable("pid") Long pid,
      Model model
  ) {

    Product findedProduct = productSVC.findById(pid);

    EditForm editForm = new EditForm();
    editForm.setProductId(findedProduct.getProductId());
    editForm.setPname(findedProduct.getPname());
    editForm.setQuantity(findedProduct.getQuantity());
    editForm.setPrice(findedProduct.getPrice());

    model.addAttribute("editForm", editForm);

    return "product/editForm";
  }

  // 수정처리
  // 수정된 회원 정보 보여주기
  @PostMapping("/{pid}/edit")
  public String update(
      @PathVariable("pid") Long pid,
      EditForm editForm
  ) {
    Product product = new Product();
    product.setProductId(pid);
    product.setPname(editForm.getPname());
    product.setQuantity(editForm.getQuantity());
    product.setPrice(editForm.getPrice());

    productSVC.update(pid, product);
    return "redirect:/products/" + pid;
  }

  // 삭제처리
  @GetMapping("/{pid}/del")
  public String del(@PathVariable("pid") Long pid) {
    productSVC.del(pid);
    return "redirect:/products";
  }

  // 목록화면
  @GetMapping
  public String all(Model model) {

    List<Product> list = productSVC.all();
    model.addAttribute("list", list);

    return "product/all";
  }
}
