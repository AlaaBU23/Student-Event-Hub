package CS673.SpringBootStudentEventHub.controller;


import CS673.SpringBootStudentEventHub.domain.po.UsersPO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IUsersService;
import CS673.SpringBootStudentEventHub.entity.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yilin
 * @version v1.0
 * @since 2023-11-13
 */
@Api(tags = {""})
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    /**
     * 查询分页数据
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById")
    public Users getById(@PathVariable Integer Id) {

        return null;
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Users add(@RequestBody UsersPO users) {
        return null;
    }


    @GetMapping(value = "/adds")
    public Integer addtest() {
        return 1;
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del")
    public String delete(@PathVariable Integer Id) {
        return null;
    }

    /**
     * 修改
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Users update(@RequestBody Users users) {
        return null;
    }

}
