package com.crazyang.controller;

import com.crazyang.core.util.AjaxObject;
import com.crazyang.entity.SwaggerTest;
import com.crazyang.service.LearnService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SwaggerTestController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/19 上午10:32.
 */


/*
@Api：用在类上，标志此类是Swagger资源
        value：接口说明
        tags：接口说明，可以在页面中显示。可以配置多个，当配置多个的时候，在页面中会显示多个接口的信息

@ApiOperation：用在方法上，描述方法的作用

@ApiImplicitParams：包装器：包含多个ApiImplicitParam对象列表

@ApiImplicitParam：定义在@ApiImplicitParams注解中，定义单个参数详细信息
        ○ paramType：参数放在哪个地方
        § header-->请求参数的获取：@RequestHeader
			§ query-->请求参数的获取：@RequestParam
			§ path（用于restful接口）-->请求参数的获取：@PathVariable
			§ body（以流的形式提交 仅支持POST）
                    § form（以form表单的形式提交 仅支持POST）
                    ○ name：参数名
                    ○ dataType：参数的数据类型 只作为标志说明，并没有实际验证
                    § Long
                    § String
                    ○ required：参数是否必须传
                    § true
                    § false
                    ○ value：参数的意义
                    ○ defaultValue：参数的默认值

@ApiModel：描述一个Swagger Model的额外信息
@ApiModel用在类上，表示对类进行说明，用于实体类中的参数接收说明

@ApiModelProperty：在model类的属性添加属性说明

@ApiParam：用于Controller中方法的参数说明

@ApiResponses：包装器：包含多个ApiResponse对象列表

@ApiResponse：定义在@ApiResponses注解中，一般用于描述一个错误的响应信息
        ○ code：错误码，例如400
        ○ message：信息，例如"请求参数没填好"
        ○ response：抛出异常的类

@Authorization	Declares an authorization scheme to be used on a resource or an operation.

@AuthorizationScope	Describes an OAuth2 authorization scope.
*/

@RestController
@RequestMapping("/api/v1")
@Api(value="Swagger Management System", description="Operations pertaining to swagger in Swagger Management System")
public class SwaggerTestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "View a list of available swaggerTest", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping("/getAll")
    public List getAll() {

        logger.info("getAll Tests,Time = "+new Date());

        List list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            SwaggerTest swaggerTest = new SwaggerTest();
            swaggerTest.setId(i);
            swaggerTest.setFirstName("test" + i);
            swaggerTest.setFirstName("last" + i);
            swaggerTest.setEmailId("email" + i);
            list.add(swaggerTest);
        }
        return list;
    }

    @GetMapping("/findById/{id}")
    public AjaxObject findById(@PathVariable(value = "id") Long id) {
        SwaggerTest swaggerTest = new SwaggerTest();
        swaggerTest.setId(id);
        swaggerTest.setFirstName("findById");
        return AjaxObject.ok().put("swaggerTest", swaggerTest);
    }

    @ApiOperation(value = "Add an swaggerTest")
    @PostMapping("/save")
    public AjaxObject save(@ApiParam(value = "SwaggerTest object store in database table", required = true)@Valid @RequestBody SwaggerTest swaggerTest) {
        System.out.println(swaggerTest);
        return AjaxObject.ok();
    }

    @ApiOperation(value = "Update an swaggerTest")
    @PostMapping("/update/{id}")
    public AjaxObject update(@PathVariable(value = "id") long id, @Valid @RequestBody SwaggerTest swaggerTest) {
        System.out.println(id);
        System.out.println(swaggerTest);
        return AjaxObject.ok();
    }

    @ApiOperation(value = "Delete an swaggerTest")
    @DeleteMapping("/delete/{id}")
    public AjaxObject delete(@PathVariable(value = "id") long id) {
        System.out.println(id);
        return AjaxObject.ok();
    }

}
