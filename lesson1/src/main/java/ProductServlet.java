import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/product/*")
    public class ProductServlet extends HttpServlet {
    private static final Pattern PARAM_PATTERN = Pattern.compile("\\/(\\d+)");
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
            this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
        }




        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product;
        String pathInfo = req.getPathInfo();
        String contextPath = req.getContextPath();
        resp.getWriter().println("request.getPathInfo() " + "<p>" + pathInfo + "</p>");
        resp.getWriter().println("request.getContextPath() " + "<p>" + contextPath + "</p>");
        if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            PrintWriter wr = resp.getWriter();
            wr.println("<table>");
            wr.println("<tr>");
            wr.println("<th>id</th>");
            wr.println("<th>productTitle</th>");
            wr.println("<th>cost</th>");
            wr.println("</tr>");

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


