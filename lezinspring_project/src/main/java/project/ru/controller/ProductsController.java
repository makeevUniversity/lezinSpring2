package project.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.ru.model.dto.ProductEntity;
import project.ru.model.services.Services;
import project.ru.model.vo.BuyerVO;
import project.ru.model.vo.ProductVO;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
public class ProductsController implements Controllers<ProductVO> {

    private Logger log = Logger.getLogger(ProductsController.class.getName());

    @Autowired
    private Services ormService;


    @Override
    @ResponseBody
    @RequestMapping(value = "/findAllProducts", method = RequestMethod.GET, produces = "application/json")
    public List<ProductVO> findAll() {
        List<ProductVO> productVOS = ormService.findAllProducts();
        return productVOS;
    }

    @ResponseBody
    @Override
    @RequestMapping(value = "/findByIdProduct", method = RequestMethod.GET, produces = "application/json")
    public ProductVO findById(@RequestParam("id") String uuid) {
        ProductVO vo = ormService.findProductById(UUID.fromString(uuid));
        return vo;
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST, produces = "application/json")
    public void update(@RequestBody ProductVO vo) {
        boolean bol = ormService.updateProduct(vo);
        log.info("Результат updateProduct: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST, produces = "application/json")
    public void insert(@RequestBody ProductVO vo) {
        vo.setId(UUID.randomUUID());
        boolean bol = ormService.insertProduct(vo);
        log.info("Результат insertProduct: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST, produces = "application/json")
    public void delete(@RequestBody ProductVO vo) {
        boolean bol = ormService.deleteProduct(vo.getId());
        log.info("Результат deleteProduct: " + bol);
    }
}
