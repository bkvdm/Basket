package tel.bvm.basket.postConstract;

import org.springframework.beans.factory.annotation.Autowired;
import tel.bvm.basket.service.MarketService;

import javax.annotation.PostConstruct;

public class TypesProducts {

    private final MarketService marketService;

    @Autowired
    public TypesProducts(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostConstruct()
    public void init() {
        marketService.addBasket("Белые грибы", null);
        marketService.addBasket("Лисички", null);
        marketService.addBasket("Вешенки", null);
        marketService.addBasket("Шампиньоны", null);
        marketService.addBasket("Опята", null);
        marketService.addBasket("Подберёзовики", null);
        marketService.addBasket("Подосиновики", null);
        marketService.addBasket("Маслята", null);
        marketService.addBasket("Грузди", null);
        marketService.addBasket("Рыжики", null);
    }
}
