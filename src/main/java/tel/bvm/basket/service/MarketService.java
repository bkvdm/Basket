package tel.bvm.basket.service;

import tel.bvm.basket.exception.ProductNotFoundException;
import tel.bvm.basket.scheme.Basket;

import java.util.Map;

public interface MarketService {
    Map<Integer, Basket> getBasket();

    Map<Integer, Basket> addBasket(String product, Integer quantity);

    Map<Integer, Basket> addIdProduct(Integer productIdentifier, Integer quantity) throws ProductNotFoundException;
}
