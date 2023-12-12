package StudentEventHub.service;

import StudentEventHub.tools.Result;
import StudentEventHub.domain.vo.UsersAddReqVO;
import StudentEventHub.domain.vo.UsersBatchReqVO;
import StudentEventHub.domain.vo.UsersRespVO;
import StudentEventHub.domain.vo.UsersUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.UsersPO;
import StudentEventHub.domain.vo.*;

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