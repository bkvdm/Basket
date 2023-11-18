package tel.bvm.basket.scheme;

public class User extends BasketUser{
    private final String loginUser;

    public User(String nameProduct, Integer quantity, String loginUser) {
        super(nameProduct, quantity);
        this.loginUser = loginUser;
    }

    public String getLoginUser() {
        return loginUser;
    }
}
