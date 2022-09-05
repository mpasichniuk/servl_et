import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductSpringController {

    private final ProductSpringRep productSpringRep;

        @GetMapping("/product.html")
        public String listPage(Model model) {
            model.addAttribute("product", productSpringRep.findAll());
            return "product";
        }

        @GetMapping("/{id}")
        public String form(@PathVariable("id") long id, Model model) {
            model.addAttribute("product", productSpringRep.findById(id));
            return "product_form";
        }

        @GetMapping("/new")
        public String addNewProductSpring(Model model) {
            model.addAttribute("product", new ProductSpring(""));
            return "product_form";
        }

        @GetMapping("/delete/{id}")
        public String deleteProductSpringById(@PathVariable long id) {
            productSpringRep.delete(id);
            return "redirect:/product";
        }

        @PostMapping
        @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
        public String saveProductSpring(@ModelAttribute ProductSpring productSpring, Model model) {
            productSpringRep.save(productSpring);
            return "redirect:/product";
        }

        @PostMapping("/update")
        public String updateProductSpring(ProductSpring productSpring) {
            productSpringRep.save(productSpring);
            return "redirect:/product";
        }


    }



