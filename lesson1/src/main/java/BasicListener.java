import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BasicListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.insert(new Product("Product 1"));
        productRepository.insert(new Product("Product 2"));
        productRepository.insert(new Product("Product 3"));
        productRepository.insert(new Product("Product 4"));
        productRepository.insert(new Product("Product 5"));
        productRepository.insert(new Product("Product 6"));
        productRepository.insert(new Product("Product 7"));
        productRepository.insert(new Product("Product 8"));
        productRepository.insert(new Product("Product 9"));
        productRepository.insert(new Product("BasicServlet.Product 10"));
        sce.getServletContext().setAttribute("productRepository", productRepository);
    }

}

