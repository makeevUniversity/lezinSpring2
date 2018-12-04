package project.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.ru.model.dto.*;
import project.ru.model.services.Services;
import project.ru.model.vo.BuyerVO;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
public class BuyersController implements Controllers<BuyerVO> {

    private Logger log = Logger.getLogger(BuyersController.class.getName());

    @Autowired
    private Services ormService;

    @Override
    @ResponseBody
    @RequestMapping(value = "/findAllBuyers", method = RequestMethod.GET, produces = "application/json")
    public List<BuyerVO> findAll() {
        return ormService.findAllBuyers();
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/findByIdBuyer", method = RequestMethod.GET, produces = "application/json")
    public BuyerVO findById(@RequestParam("id") String uuid) {
        BuyerVO vo = ormService.findBuyerById(UUID.fromString(uuid));
        return vo;
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/updateBuyer", method = RequestMethod.POST, produces = "application/json")
    public void update(@RequestBody BuyerVO vo) {
        boolean bol = ormService.updateBuyer(vo);
        log.info("Результат updateBuyer: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/insertBuyer", method = RequestMethod.POST, produces = "application/json")
    public void insert(@RequestBody BuyerVO vo) {
        vo.setId(UUID.randomUUID());
        boolean bol = ormService.insertBuyer(vo);
        log.info("Результат insertBuyer: " + bol);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/deleteBuyer", method = RequestMethod.POST, produces = "application/json")
    public void delete(@RequestBody BuyerVO vo) {
        boolean bol = ormService.deleteBuyer(vo.getId());
        log.info("Результат deleteBuyer: " + bol);
    }
}
