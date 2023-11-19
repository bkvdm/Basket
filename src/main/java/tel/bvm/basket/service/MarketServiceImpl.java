package tel.bvm.basket.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import tel.bvm.basket.scheme.Basket;

import java.util.*;

@SessionScope
@Service
public class MarketServiceImpl implements MarketService {

    public final Map<String, Basket> basketMap;

    public MarketServiceImpl(Map<String, Basket> basketMap) {
        this.basketMap = basketMap;
    }

    @Override
    public Map<String, Basket> getBasket() {
        return Collections.unmodifiableMap(basketMap);
    }

    @Override
    public Map<String, Basket> addBasket(String product, Integer quantity) {
        Basket basket = new Basket(product, quantity);
        basketMap.put(product, basket);
        return basketMap;
    }

    @Override
    public Map<String, Basket> addIdProduct(Integer productIdentifier, Integer quantity) {
        Basket foundProduct = null;
        String foundProductName = null;

        boolean checkProductIdentifier = productIdentifier == null && productIdentifier > basketMap.size();
        if (!checkProductIdentifier) {
            for (int i = 0; i < basketMap.size(); i++) {
                if (basketMap.get(i).getProductIdentifier().equals(productIdentifier)) {
                    foundProduct = basketMap.get(i);
                    foundProductName = foundProduct.getProduct();
                    break;
                }
            }
        } else {
            throw new RuntimeException();
        }
        if (foundProduct != null) {
            foundProduct.setQuantity(quantity);
            basketMap.put(foundProductName, foundProduct);
        }
        return basketMap;
    }

    @Override
    public Map<String, Basket> addTypeProductBasket(String product, Integer quantity) {
        Basket basket = new Basket(product, quantity);
        basketMap.put(product, basket);
        return basketMap;
    }
}

