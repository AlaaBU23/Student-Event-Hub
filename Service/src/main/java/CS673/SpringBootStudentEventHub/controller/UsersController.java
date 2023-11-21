package CS673.SpringBootStudentEventHub.controller;


import CS673.SpringBootStudentEventHub.tools.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IUsersService;
import CS673.SpringBootStudentEventHub.entity.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import CS673.SpringBootStudentEventHub.domain.po.UsersPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
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
 * @since 2023-11-14
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

        return usersService.page(new Page<>(pageNum,pageSize));
    }


    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public UsersRespVO getById(@PathVariable String Id) {

        return usersService.getUsers(Id);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UsersRespVO add(@RequestBody UsersAddReqVO UsersAddVO) {
        return usersService.addUsers(UsersAddVO);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return usersService.deleteUsers(Id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public UsersRespVO update(@RequestBody UsersUpdateReqVO UpdateReqVO) {
        return usersService.updateUsers(UpdateReqVO);
    }

    @ApiOperation(value = "LogIn")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result logIn(@RequestBody UsersAddReqVO users){
        return usersService.logIn(users);
    }

    @ApiOperation(value = "CurrentUser")
    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    public Result currentUser(@RequestHeader("Authorization") String token){
        return usersService.findUserByToken(token);
    }

    @ApiOperation(value = "logOut")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Result logOut(@RequestHeader("Authorization") String token){
        return usersService.logOut(token);
    }

}
