package com.example.E_commerce.dto;

import java.util.List;

public class OrderRequest {
	private List<Long> productIds;

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;

		}
}
