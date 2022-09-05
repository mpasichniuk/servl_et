import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductSpringRep {

    private final Map<Long, ProductSpring> productSpringMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new ProductSpring("Product 1", 1L, 3));
        this.insert(new ProductSpring("Product 2", 3L, 4));
        this.insert(new ProductSpring("Product 3", 1L, 1));
        this.insert(new ProductSpring("Product 4", 6L, 6));
        this.insert(new ProductSpring("Product 5", 5L, 5));
    }

    public List<ProductSpring> findAll() {
        return new ArrayList<>(productSpringMap.values());
    }

    public ProductSpring findById(long id) {
        return productSpringMap.get(id);
    }

    public void insert(ProductSpring productSpring) {
        long id = identity.incrementAndGet();
        productSpring.setId(id);
      productSpringMap.put(id, productSpring);
    }

    public ProductSpring save(ProductSpring productSpring) {
        if (productSpring.getId() == null) {
            productSpring.setId(identity.incrementAndGet());
        }
        productSpringMap.put(productSpring.getId(),productSpring);
        return productSpring;
    }

    public void delete(long id) {
        productSpringMap.remove(id);
    }

}



