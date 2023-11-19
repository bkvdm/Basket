package tel.bvm.basket.scheme;

public class Basket {
    private String product;
    private final int productIdentifier;
    private static int productIdentifierGenerate = 1;
    private Integer quantity;

    public Basket(String product, Integer quantity) {
        this.product = product;
        this.productIdentifier = productIdentifierGenerate++;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getProductIdentifier() {
        return productIdentifier;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
