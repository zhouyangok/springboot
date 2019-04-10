package com.crazyang.controller;

import com.crazyang.common.baseClass.AjaxObject;
import com.crazyang.common.baseClass.Page;
import com.crazyang.common.exception.BusinessException;
import com.crazyang.entity.LearnResource;
import com.crazyang.entity.User;
import com.crazyang.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Description: 用户控制类
 * @Author zhouyang
 * @Date 2019/3/8 上午9:56.
 */
@Api(value = "用户管理", description = "用户管理控制类")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "获取所有用户信息", response = AjaxObject.class)
    @GetMapping("/getUsers")
    public AjaxObject getUsers(Page page) {
        List<User> userList = userService.queryUserList(page);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return AjaxObject.ok().put("pageInfo", pageInfo);
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据用户id查看用户信息", response = AjaxObject.class)
    @GetMapping("/getUserById/{id}")
    public AjaxObject getUserById(@PathVariable(value = "id") int id) {
        User user = userService.getOne(id);
        return AjaxObject.ok().put("user", user);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param name
     * @return
     */
    @ApiParam(value = "name")
    @ApiOperation(value = "根据用户名查看用户信息", response = AjaxObject.class)
    @GetMapping("/getUserByName")
    public AjaxObject getUserByName(@RequestParam("name") String name) {
        User user;
        try {
            user = userService.findByName(name);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return AjaxObject.ok().put("user", user);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户", response = AjaxObject.class)
    @ApiImplicitParams({
            @ApiImplicitParam( dataType = "String", name = "name", value = "用户名", required = true)
            , @ApiImplicitParam( dataType = "String", name = "password", value = "密码", required = true)
    })
    @PostMapping("/insert")
    public AjaxObject insert(User user) {
        try {
            userService.insert(user);
        } catch (BusinessException e) {
            return AjaxObject.error(e.getCode(), e.getMsg());
        }
        return AjaxObject.ok("新增用户成功");
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户", response = AjaxObject.class)
    @ApiImplicitParams({
            @ApiImplicitParam( dataType = "int", name = "id", value = "用户id", required = true)
            , @ApiImplicitParam( dataType = "String", name = "name", value = "用户名", required = true)
    })
    @PostMapping("/update")
    public AjaxObject update(User user) {
        try {
            userService.update(user);
        } catch (BusinessException e) {
            return AjaxObject.error(e.getCode(), e.getMsg());
        }
        return AjaxObject.ok();
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @ApiImplicitParam( dataType = "int", name = "id", value = "用户id", required = true)
    @ApiOperation(value = "根据id删除用户", response = AjaxObject.class)
    @GetMapping("/delete/{id}")
    public AjaxObject deleteById(@PathVariable(value = "id") int id) {
        try {
            userService.deleteById(id);
        } catch (BusinessException e) {
            return AjaxObject.error(e.getCode(), e.getMsg());
        }
        return AjaxObject.ok();
    }
}
