package project.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.ru.model.dto.DiscountEntity;
import project.ru.model.services.Services;
import project.ru.model.vo.DiscountVO;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
public class DiscountsController implements Controllers<DiscountVO> {

    private Logger log = Logger.getLogger(DiscountsController.class.getName());

    @Autowired
    private Services ormService;

    @Override
    @ResponseBody
    @RequestMapping(value = "/findAllDiscounts", method = RequestMethod.GET, produces = "application/json")
    public List<DiscountVO> findAll() {
        List<DiscountVO> discounts = ormService.findAllDiscounts();
        return discounts;
    }

    @ResponseBody
    @Override
    @RequestMapping(value = "/findByIdDiscount", method = RequestMethod.GET, produces = "application/json")
    public DiscountVO findById(@RequestParam("id") String uuid) {
        return ormService.findDiscountById(UUID.fromString(uuid));
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/updateDiscount", method = RequestMethod.POST, produces = "application/json")
    public void update(@RequestBody DiscountVO vo) {
        boolean bol = ormService.updateDiscount(vo);
        log.info("Результат updateDiscount: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/insertDiscount", method = RequestMethod.POST, produces = "application/json")
    public void insert(@RequestBody DiscountVO vo) {
        vo.setId(UUID.randomUUID());
        boolean bol = ormService.insertDiscount(vo);
        log.info("Результат insertDiscount: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/deleteDiscount", method = RequestMethod.POST, produces = "application/json")
    public void delete(@RequestBody DiscountVO vo) {
        boolean bol = ormService.deleteDiscount(vo.getId());
        log.info("Результат deleteDiscount: " + bol);
    }

    @ResponseBody
    @RequestMapping(value = "/findDiscountByIdSellerAndProduct", method = RequestMethod.GET, produces = "application/json")
    public DiscountVO findDiscountByIdSellerAndProduct(@RequestParam("idSeller") String idSeller,
                                                       @RequestParam("idProduct") String idProduct) {
        return ormService.findDiscountByIdSellerAndProduct(UUID.fromString(idSeller),UUID.fromString(idProduct));
    }
}
