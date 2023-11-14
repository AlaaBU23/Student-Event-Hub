package CS673.SpringBootStudentEventHub.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import CS673.SpringBootStudentEventHub.domain.po.UsersPO;
import CS673.SpringBootStudentEventHub.tools.*;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IUsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import CS673.SpringBootStudentEventHub.mapper.UsersMapper;

/**
 * @author yilin
 * @date 2023-11-13
 */
@Service
@Slf4j
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersPO> implements IUsersService {

    @Autowired
    private UsersMapper Users_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public UsersRespVO getUsers(String id) {
        UsersRespVO vo = new UsersRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<UsersPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            vo = toVO(Users_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer deleteUsers(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<UsersPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            deleteCount = Users_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Users
     *
     * @param UsersAddVO
     * @return UsersRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UsersRespVO addUsers(UsersAddReqVO UsersAddVO) {
        UsersRespVO vo = new UsersRespVO();
        if (UsersAddVO != null) {
            fillingAddParams(UsersAddVO);
            UsersPO po = fromReqVO(UsersAddVO);
            Users_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Users
     *
     * @param Users_UpdateReqVO
     * @return UsersRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UsersRespVO updateUsers(UsersUpdateReqVO Users_UpdateReqVO) {
        UsersRespVO vo = new UsersRespVO();
        if (Users_UpdateReqVO != null) {
            fillingUpdateParams(Users_UpdateReqVO);
            QueryWrapper<UsersPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("UsersId", Users_UpdateReqVO.getUserId());
            UsersPO po = fromReqVO(Users_UpdateReqVO);
            Users_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Users
     *
     * @param Users_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteUsersList(UsersBatchReqVO Users_BatchReqVO) {
        Integer deleteCount = 0;
        if (Users_BatchReqVO != null) {
            List<String> ids = Users_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<UsersPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("UsersId", ids);
                deleteCount = Users_Mapper.delete(queryWrapper);
            }
        }
        return deleteCount;
    }

    /**
     * addReqVO转po
     *
     * @param queryVO
     * @return po
     */
    private UsersPO fromReqVO(UsersAddReqVO queryVO) {
        UsersPO po = new UsersPO();
        if (queryVO != null) {
            BeanUtils.copyProperties(queryVO, po);
        }
        return po;
    }

    /**
     * updateReq转po
     *
     * @param queryVO
     * @return po
     */
    private UsersPO fromReqVO(UsersUpdateReqVO queryVO) {
        UsersPO po = new UsersPO();
        if (queryVO != null) {
            BeanUtils.copyProperties(queryVO, po);
        }
        return po;
    }


    /**
     * po转vo
     *
     * @param po
     * @return vo
     */
    private UsersRespVO toVO(UsersPO po) {
        UsersRespVO vo = new UsersRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(UsersAddReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getUserId())) {
            queryVO.setUserId(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingUpdateParams(UsersUpdateReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getUserId())) {
            queryVO.setUserId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}