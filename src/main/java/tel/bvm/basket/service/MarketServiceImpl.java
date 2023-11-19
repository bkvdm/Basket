package tel.bvm.basket.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import tel.bvm.basket.scheme.Basket;

import javax.annotation.PostConstruct;
import java.util.*;

@SessionScope
@Service
public class MarketServiceImpl implements MarketService {

    public Map<String, Basket> basketMap;

    public MarketServiceImpl() {
        this.basketMap = new HashMap<>();
    }

    @PostConstruct()
    public void init() {
        addTypeProductBasket("Белые грибы", null);
        addTypeProductBasket("Лисички", null);
        addTypeProductBasket("Вешенки", null);
        addTypeProductBasket("Шампиньоны", null);
        addTypeProductBasket("Опята", null);
        addTypeProductBasket("Подберёзовики", null);
        addTypeProductBasket("Подосиновики", null);
        addTypeProductBasket("Маслята", null);
        addTypeProductBasket("Грузди", null);
        addTypeProductBasket("Рыжики", null);
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

        if (productIdentifier != null) {

            basketMap.forEach((k, v) -> {
                if (v.getProductIdentifier().equals(productIdentifier)) {
                    Basket basketNewQuantity = new Basket(k, quantity);
//                            v.setQuantity(quantity);
                    basketMap.put(k, basketNewQuantity);
                }
            });

        } else {
            throw new RuntimeException();
        }
        return basketMap;
    }

    @Override
    public Map<String, Basket> addTypeProductBasket(String product, Integer quantity) {
        Basket basket = new Basket(product, quantity);
        basket.setQuantity(null);
        basketMap.put(product, basket);
        return basketMap;
    }
}