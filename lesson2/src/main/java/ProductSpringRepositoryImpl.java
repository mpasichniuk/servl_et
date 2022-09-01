import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductSpringRepositoryImpl implements ProductSpringRepository{
    private final Map<Long, ProductSpring> productMap = new HashMap<>();

    @PostConstruct
    public void init() {
        addProductSpring(1L, new ProductSpring("product1", 1, 50));
        addProductSpring(2L, new ProductSpring("product2", 2, 10));
        addProductSpring(3L, new ProductSpring("product3", 3, 40));
        addProductSpring(4L, new ProductSpring("product4", 4, 20));
        addProductSpring(5L, new ProductSpring("product5", 5, 30));
    }

    @Override
    public ProductSpring findProductSpringById(Long id) {
        return productMap.get(id);
    }

    @Override
    public void addProductSpring(Long id, ProductSpring productSpring) {
        productMap.put(id, productSpring);
    }
}

