package shop.mtcoding.buyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.Purchase;
import shop.mtcoding.buyer.model.PurchaseRepository;

@Service
public class PurchaseService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional
    public int buy(int userId, int productId, int count) {
        // 1. 상품 존재 확인
        Product product = productRepository.findById(productId);

        if (product == null) {
            return -1;
        }

        // 2. 상품 수량 확인
        if (product.getQty() < count) {
            return -1;
        }

        // 3. 재고 수량 변경
        int result = productRepository.updateById(product.getId(), product.getName(), product.getPrice(),
                product.getQty() - count);

        if (result != 1) {
            return -1;
        }

        // 4. 구매 기록 변경
        int result2 = purchaseRepository.insert(userId, productId, count);
        if (result2 != 1) {
            return -1;
        }

        return 1;
    }

    @Transactional
    public int delete(int id) {
        // 구매 내역 존재 확인
        Purchase purchase = purchaseRepository.findById(id);

        if (purchase == null) {
            return -1;
        }

        // 재고 +
        Product product = productRepository.findById(purchase.getProductId());
        int result = productRepository.updateById(product.getId(), product.getName(), product.getPrice(),
                product.getQty() + purchase.getCount());

        // 재고 원상복구 확인
        if (result != 1) {
            return -1;
        }

        // 구매 내역 삭제
        int result2 = purchaseRepository.deleteById(purchase.getId());
        if (result2 != 1) {
            return -1;
        }

        return 1;

    }
}
