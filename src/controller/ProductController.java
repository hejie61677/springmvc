package controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import entity.Product;

/**
 * 
 * <p>Title:ProductController </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午4:58:49
 */
@Controller
public class ProductController {
 
    @RequestMapping("/addProduct")
    public ModelAndView add (Product product) throws Exception {
        ModelAndView mv = new ModelAndView("showProduct");
        return mv;
    }
}