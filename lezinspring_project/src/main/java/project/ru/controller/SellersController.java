package project.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.ru.model.dto.SellerEntity;
import project.ru.model.services.Services;
import project.ru.model.vo.SaleVO;
import project.ru.model.vo.SellerVO;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
public class SellersController implements Controllers<SellerVO> {

    private Logger log = Logger.getLogger(SellersController.class.getName());

    @Autowired
    private Services ormService;

    @ResponseBody
    @RequestMapping(value = "/findAllSellers", method = RequestMethod.GET, produces = "application/json")
    public List<SellerVO> findAll() {
        List<SellerVO> sellerVOS = ormService.findAllSellers();
        return sellerVOS;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/findByIdSeller", method = RequestMethod.GET, produces = "application/json")
    public SellerVO findById(@RequestParam("id") String uuid) {
        SellerVO vo = ormService.findSellerById(UUID.fromString(uuid));
        return vo;
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/updateSeller", method = RequestMethod.POST, produces = "application/json")
    public void update(@RequestBody SellerVO vo) {
        boolean bol = ormService.updateSeller(vo);
        log.info("Результат updateSeller: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/insertSeller", method = RequestMethod.POST, produces = "application/json")
    public void insert(@RequestBody SellerVO vo) {
        vo.setId(UUID.randomUUID());
        boolean bol = ormService.insertSeller(vo);
        log.info("Результат insertSeller: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/deleteSeller", method = RequestMethod.POST, produces = "application/json")
    public void delete(@RequestBody SellerVO vo) {
        boolean bol = ormService.deleteSeller(vo.getId());
        log.info("Результат deleteSeller: " + bol);
    }

}
