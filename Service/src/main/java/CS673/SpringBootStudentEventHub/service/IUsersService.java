package CS673.SpringBootStudentEventHub.service;

import CS673.SpringBootStudentEventHub.tools.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.UsersPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.UsersMapper;

/**
 * <p>
 * $!{table.comment} service class
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IUsersService extends IService<UsersPO> {
    public UsersRespVO getUsers(String id);

    public Integer deleteUsers(String id);

    public UsersRespVO addUsers(UsersAddReqVO UsersAddVO);

    public UsersRespVO updateUsers(UsersUpdateReqVO Users_UpdateReqVO);

    public Integer deleteUsersList(UsersBatchReqVO Users_BatchReqVO);

    public Result logIn(UsersAddReqVO users);

    public Result findUserByToken(String token);

    public Result logOut(String token);
}