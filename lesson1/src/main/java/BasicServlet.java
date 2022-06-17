import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/first_servlet")
public class BasicServlet implements Servlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        res.getWriter().println("</table>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    public static class Product {
        private Long id;
        private String productTitle;
        private int cost;

        public Product(String productTitle){
            this.productTitle = productTitle;
        }
        public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id = this.id;
        }
        public String getProductTitle(){
            return productTitle;
        }
        public void setProductTitle(){
            this.productTitle = productTitle;
        }
        public void setCost(){
            this.cost = cost;
        }
        public int getCost(){
            return cost;
        }

        public void put(Long id, Product products) {
        }
    }
}
