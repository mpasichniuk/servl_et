public interface ProductSpringRepository {

    ProductSpring findProductSpringById(Long id);

    void addProductSpring(Long id, ProductSpring productSpring);
}
