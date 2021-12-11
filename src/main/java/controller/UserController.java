package controller;

import domain.AccountDTO;
import domain.StockDTO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.interfaces.IAccountService;
import service.interfaces.IStockService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller // TODO: Controller Setting
public class UserController {
    @Autowired
    private IAccountService userService;
    // TODO: Resouces, Inject, Autowired, Quilfyer - 차이점 확인 후 사용


    @RequestMapping(value = "/user1", method = RequestMethod.GET)
    @ApiOperation(value = "유저 페이지", notes = "유저를 입력할 수 있는 페이지로 이동합니다.")
    public String goUser1() {
        return "user1";
    }

    @RequestMapping(value = "/user2", method = RequestMethod.POST)
    @ApiOperation(value = "유저 페이지", notes = "유저를 받을 수 있는 페이지로 이동합니다.")
    public ModelAndView goStudent(HttpServletRequest httpServletRequest) {
        String userid = httpServletRequest.getParameter("userid");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user2");
        mav.addObject("userId", userid);
        return mav;
    }

    @ResponseBody
    @ApiOperation(value = "유저 페이지", notes = "유저의 정보를 가져옵니다.")
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public List<AccountDTO> getAccountList() {
        return userService.getAccountList();
    }
}
