package StudentEventHub.controller;


import StudentEventHub.domain.vo.GroupmembersAddReqVO;
import StudentEventHub.domain.vo.GroupmembersRespVO;
import StudentEventHub.domain.vo.GroupmembersUpdateReqVO;
import StudentEventHub.service.IGroupmembersService;
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
@RequestMapping("/groupmembers")
@CrossOrigin(origins = "*")
public class GroupmembersController {
    @Autowired
    private IGroupmembersService groupmembersService;

    /**
     * search page data
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * get group member information by member id
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public GroupmembersRespVO getById(@PathVariable String Id) {

        return groupmembersService.getGroupmembers(Id);
    }

    /**
     * create a new group member
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public GroupmembersRespVO add(@RequestBody GroupmembersAddReqVO GroupmembersAddVO) {
        return groupmembersService.addGroupmembers(GroupmembersAddVO);
    }

    /**
     * delete group member
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return groupmembersService.deleteGroupmembers(Id);
    }

    /**
     * edit / update group member information
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public GroupmembersRespVO update(@RequestBody GroupmembersUpdateReqVO UpdateReqVO) {
        return groupmembersService.updateGroupmembers(UpdateReqVO);
    }

}
