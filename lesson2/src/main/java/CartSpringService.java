import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class CartSpringService {

    

    public CartSpringService(ProductSpringRepository productSpringRepository) {


        this.productSpringRepository = productSpringRepository;
    }

    private final CartSpring cartSpring = new CartSpring();
    private final ProductSpringRepository productSpringRepository;
    public void addProductSpringToCart(Long id) {
            ProductSpring productSpring = productSpringRepository.findProductSpringById(id);
            cartSpring.add(productSpring);
        }

        public void removeProductSpringFromCart(Long productSpringId) {
            ProductSpring productSpring = productSpringRepository.findProductSpringById(productSpringId);
            cartSpring.remove(productSpring);
        }

        public List<ProductSpring> getCartSpringProducts() {
            return cartSpring.getAllProductsSpring();
        }


    }


