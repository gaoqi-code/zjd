package com.bbc.action;

import com.bbc.entity.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
    public BaseController() {
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    private String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cs = request.getCookies();
        if(cs != null) {
            Cookie[] arr$ = cs;
            int len$ = cs.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Cookie c = arr$[i$];
                if(c.getName().equals(name)) {
                    return c.getValue();
                }
            }
        }

        return null;
    }


    public int getUserId(HttpServletRequest request) {
        User member = (User) request.getSession().getAttribute("user");
        Integer memberId = null;
        if(member != null) {
//            memberId = assertion.getPrincipal().getAttributes().get("memberId");
            memberId = member.getId();
        }

        return memberId != null?memberId:-1;
    }

}


