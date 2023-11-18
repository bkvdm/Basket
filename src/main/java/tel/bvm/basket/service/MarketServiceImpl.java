package tel.bvm.basket.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import tel.bvm.basket.exception.ProductNotFoundException;
import tel.bvm.basket.scheme.Basket;

import java.util.*;

@SessionScope
@Service
public class MarketServiceImpl implements MarketService {

    public final Map<Integer, Basket> basketMap;

    public MarketServiceImpl(Map<Integer, Basket> basketMap) {
        this.basketMap = basketMap;
    }

    @Override
    public Map<Integer, Basket> getBasket() {
        return Collections.unmodifiableMap(basketMap);
    }

    @Override
    public Map<Integer, Basket> addBasket(String product, Integer quantity) {
        Basket basket = new Basket(product, quantity);
        basketMap.put(basket.getProductIdentifier(), basket);
        return basketMap;
    }

    @Override
    public Map<Integer, Basket> addIdProduct(Integer productIdentifier, Integer quantity) throws ProductNotFoundException {
        Basket foundProduct = null;

        boolean checkProductIdentifier = productIdentifier == null && productIdentifier > basketMap.size();
        if (!checkProductIdentifier) {
            for (int i = 0; i < basketMap.size(); i++) {
                if (basketMap.get(i).getProductIdentifier().equals(productIdentifier)) {
                    foundProduct = basketMap.get(i);
                    break;
                }
            }
            foundProduct.setQuantity(quantity);
        } else {
            throw new ProductNotFoundException();
        }
        return basketMap;
    }
}
