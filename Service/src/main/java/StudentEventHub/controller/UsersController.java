package StudentEventHub.controller;


import StudentEventHub.tools.Result;
import StudentEventHub.domain.vo.UsersAddReqVO;
import StudentEventHub.domain.vo.UsersRespVO;
import StudentEventHub.domain.vo.UsersUpdateReqVO;
import StudentEventHub.service.IUsersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import StudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Front-end controller
 * </p>
 *
 * @author yilin
 * @version v1.0
 * @since 2023-11-14
 */
@Api(tags = {""})
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    /**
     * get page data
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return usersService.page(new Page<>(pageNum,pageSize));
    }


    /**
     * get user information by id
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public UsersRespVO getById(@PathVariable String Id) {

        return usersService.getUsers(Id);
    }

    /**
     * add new user
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UsersRespVO add(@RequestBody UsersAddReqVO UsersAddVO) {
        return usersService.addUsers(UsersAddVO);
    }

    /**
     * delete user
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return usersService.deleteUsers(Id);
    }

    /**
     * update user
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public UsersRespVO update(@RequestBody UsersUpdateReqVO UpdateReqVO) {
        return usersService.updateUsers(UpdateReqVO);
    }

    /**
     * user login feature
     * @param users
     * @return
     */
    @ApiOperation(value = "LogIn")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result logIn(@RequestBody UsersAddReqVO users){
        return usersService.logIn(users);
    }

    /**
     * get user information by token
     * @param token
     * @return
     */
    @ApiOperation(value = "CurrentUser")
    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    public Result currentUser(@RequestHeader("Authorization") String token){
        return usersService.findUserByToken(token);
    }

    /**
     * log out
     * @param token
     * @return
     */
    @ApiOperation(value = "logOut")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Result logOut(@RequestHeader("Authorization") String token){
        return usersService.logOut(token);
    }

}
