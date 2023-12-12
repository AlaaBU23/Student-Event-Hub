package StudentEventHub.controller;


import StudentEventHub.domain.vo.EventgroupsAddReqVO;
import StudentEventHub.domain.vo.EventgroupsRespVO;
import StudentEventHub.domain.vo.EventgroupsUpdateReqVO;
import StudentEventHub.service.IEventgroupsService;
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
@RequestMapping("/eventgroups")
@CrossOrigin(origins = "*")
public class EventgroupsController {
    @Autowired
    private IEventgroupsService eventgroupsService;

    /**
     * search page data
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * get event group information by group id
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public EventgroupsRespVO getById(@PathVariable String Id) {

        return eventgroupsService.getEventgroups(Id);
    }

    /**
     * add new event group
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public EventgroupsRespVO add(@RequestBody EventgroupsAddReqVO EventgroupsAddVO) {
        return eventgroupsService.addEventgroups(EventgroupsAddVO);
    }

    /**
     * delete event group
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return eventgroupsService.deleteEventgroups(Id);
    }

    /**
     * edit / update event group information
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public EventgroupsRespVO update(@RequestBody EventgroupsUpdateReqVO UpdateReqVO) {
        return eventgroupsService.updateEventgroups(UpdateReqVO);
    }

}
