import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Scope("prototype")
public class CartSpring {
    private Set<ProductSpring> cartSpring = new HashSet<>();

    public void add(ProductSpring productSpring) {
        cartSpring.add(productSpring);
    }

    public void remove(ProductSpring productSpring) {
        cartSpring.remove(productSpring);
    }

    public List<ProductSpring> getAllProductsSpring() {
        return new ArrayList<>(cartSpring);
    }
}

