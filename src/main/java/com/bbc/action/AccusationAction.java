package com.bbc.action;

import com.bbc.entity.Accusation;
import com.bbc.service.AccusationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("accusa")
public class AccusationAction {

    @Autowired
    private AccusationService accusationService;

    /**
     * Created by gonglixun on 2016/12/13.
     * 跳转到网站首页
     */
    @RequestMapping(value = "/add")
    public String toIndex(HttpServletRequest request, Accusation a) {
        accusationService.addAccusation(a);
        return "view/index";
    }

}
