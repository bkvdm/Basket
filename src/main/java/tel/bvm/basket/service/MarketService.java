package tel.bvm.basket.service;

import tel.bvm.basket.scheme.Basket;

import java.util.Map;

public interface MarketService {
    Map<String, Basket> getBasket();

    Map<String, Basket> addBasket(String product, Integer quantity);

    Map<String, Basket> addIdProduct(Integer productIdentifier, Integer quantity);

    Map<String, Basket> addTypeProductBasket(String product, Integer quantity);
}
