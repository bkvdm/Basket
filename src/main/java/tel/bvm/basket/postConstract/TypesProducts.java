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
        marketService.addTypeProductBasket("Белые грибы", null);
        marketService.addTypeProductBasket("Лисички", null);
        marketService.addTypeProductBasket("Вешенки", null);
        marketService.addTypeProductBasket("Шампиньоны", null);
        marketService.addTypeProductBasket("Опята", null);
        marketService.addTypeProductBasket("Подберёзовики", null);
        marketService.addTypeProductBasket("Подосиновики", null);
        marketService.addTypeProductBasket("Маслята", null);
        marketService.addTypeProductBasket("Грузди", null);
        marketService.addTypeProductBasket("Рыжики", null);
    }
}
