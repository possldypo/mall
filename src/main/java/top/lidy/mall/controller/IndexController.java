package top.lidy.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lidy.mall.Constant;

/**
 * @Author lidey
 * @DATE 2019/2/11
 */
@Controller
public class IndexController extends BaseController {



    @RequestMapping(value = {"/","/index","INDEX"})
    public String index(){
        return Constant.VIEW_INDEX;
    }

}
