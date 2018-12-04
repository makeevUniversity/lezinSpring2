package project.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.ru.model.services.Services;
import project.ru.model.vo.SaleVO;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
public class SalesController implements Controllers<SaleVO>{

    private Logger log = Logger.getLogger(SalesController.class.getName());

    @Autowired
    private Services ormService;

    @Override
    @ResponseBody
    @RequestMapping(value = "/findAllSales", method = RequestMethod.GET, produces = "application/json")
    public List<SaleVO> findAll() {
        List<SaleVO> saleVOS = ormService.findAllSales();
        return saleVOS;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/findByIdSale", method = RequestMethod.GET, produces = "application/json")
    public SaleVO findById(@RequestParam("id") String uuid) {
        SaleVO vo=ormService.findSaleById(UUID.fromString(uuid));
        return vo;
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/updateSale", method = RequestMethod.POST, produces = "application/json")
    public void update(@RequestBody SaleVO vo) {
        boolean bol = ormService.updateSale(vo);
        log.info("Результат updateSale: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/insertSale", method = RequestMethod.POST, produces = "application/json")
    public void insert(@RequestBody SaleVO vo) {
        vo.setId(UUID.randomUUID());
        boolean bol = ormService.insertSale(vo);
        log.info("Результат insertSale: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/deleteSale", method = RequestMethod.POST, produces = "application/json")
    public void delete(@RequestBody SaleVO vo) {
        boolean bol = ormService.deleteSale(vo.getId());
        log.info("Результат deleteSale: " + bol);
    }
}
