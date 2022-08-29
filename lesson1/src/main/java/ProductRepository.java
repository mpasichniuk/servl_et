import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepository {
static final Map<Long, Product> products = new ConcurrentHashMap<>();
static final AtomicLong identity = new AtomicLong(0);


    public static List<Product> findAll() {
        return new ArrayList<>(products.values());
    }


    public static void saveOrUpdate(Product products) {
        if (products.getId() == null) {
            Long id = identity.incrementAndGet();
            products.setId(id);
        }
        products.put(products.getId(), products);
    }


    public static Product findById(Long id) { return products.get(id); }


    public static void deleteById(Long id) {
        products.remove(id);
    }

    void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        products.put(id, product);
    }
}


