package tel.bvm.basket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tel.bvm.basket.scheme.Basket;
import tel.bvm.basket.service.MarketService;

import java.util.Map;

@RestController
@RequestMapping("/store/order")
public class OrderController {

    private final MarketService marketService;

    public OrderController(MarketService marketService) {
        this.marketService = marketService;
    }

    @RequestMapping("/get")
    public Map<String, Basket> getBasket() {
        return marketService.getBasket();
    }

    @RequestMapping("/add")
    public Map<String, Basket> basketMap (@RequestParam(value = "product", required = false) String product, @RequestParam(value = "quantity", required = false) Integer quantity) {
        return marketService.addBasket(product, quantity);
    }
    @RequestMapping("/addIdProduct")
    public Map<String, Basket> addIdProduct (@RequestParam(value = "productIdentifier", required = false) Integer productIdentifier, @RequestParam(value = "quantity", required = false) Integer quantity) {
        return marketService.getBasket();
    }

}
