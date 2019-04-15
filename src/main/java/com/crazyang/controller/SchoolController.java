/*
package com.crazyang.controller;

import com.crazyang.common.baseClass.AjaxObject;
import com.crazyang.entity.SchoolEntity;
import com.crazyang.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @ClassName SchoolController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/4/15 下午5:34.
 *//*


@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/getByName")
    public AjaxObject getByName(@RequestParam("name") String name) {
        School vo = schoolService.findByName(name);
        return AjaxObject.ok().put("school", vo);
    }
}
*/
