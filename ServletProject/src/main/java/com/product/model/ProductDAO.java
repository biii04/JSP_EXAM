package com.product.model;

import java.util.ArrayList;

public interface ProductDAO {
	//추가
	public void productInsert(Product product);
	//전체보기
	public ArrayList<Product> productAllfind();
	
	//상세보기
	public Product findById(Long productId);

}
   