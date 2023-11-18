package tel.bvm.basket.scheme;

public class BasketUser extends Product{

    public Integer quantity;

    public BasketUser(String nameProduct, Integer quantity) {
        super(nameProduct);
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
