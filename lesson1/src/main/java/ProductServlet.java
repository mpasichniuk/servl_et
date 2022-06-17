import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/product")
    public class ProductServlet extends HttpServlet {
    private static final Pattern PARAM_PATTERN = Pattern.compile("\\/(\\d+)");
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository.insert(new Product("BasicServlet.Product 1"));
        productRepository.insert(new Product("BasicServlet.Product 2"));
        productRepository.insert(new Product("BasicServlet.Product 3"));
        productRepository.insert(new Product("BasicServlet.Product 4"));
        productRepository.insert(new Product("BasicServlet.Product 5"));
        productRepository.insert(new Product("BasicServlet.Product 6"));
        productRepository.insert(new Product("BasicServlet.Product 7"));
        productRepository.insert(new Product("BasicServlet.Product 8"));
        productRepository.insert(new Product("BasicServlet.Product 9"));
        productRepository.insert(new Product("BasicServlet.Product 10"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product;
        if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            PrintWriter wr = resp.getWriter();

            for (Product products : ProductRepository.findAll()) {
                wr.println("<tr>");
                wr.println("<td><a href='" + req.getContextPath() + "/product/" + products.getId() + "'>" + products.getId() + "</a></td>");
                wr.println("<td>" + products.getProductTitle() + "</td>");
                wr.println("</tr>");
            }

            wr.println("</table>");
        } else {


            {
                Matcher matcher = PARAM_PATTERN.matcher(req.getPathInfo());
                if (matcher.matches()) {
                    long id = Long.parseLong(matcher.group(1));
                    product = ProductRepository.findById(id);
                    if (product == null) {
                        resp.getWriter().println("Product not found");
                        resp.setStatus(404);
                        return;
                    }
                    req.setAttribute("product", ProductRepository.findById(id));
                    getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);;
                } else {
                    resp.getWriter().println("Bad parameter value");
                    resp.setStatus(400);
                }
            }
        }
    }
}


