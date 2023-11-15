package CS673.SpringBootStudentEventHub.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IEventgroupsService;
import CS673.SpringBootStudentEventHub.entity.Eventgroups;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import CS673.SpringBootStudentEventHub.domain.po.EventgroupsPO;
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
@RequestMapping("/eventgroups")
public class EventgroupsController {
    @Autowired
    private IEventgroupsService eventgroupsService;

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
    public EventgroupsRespVO getById(@PathVariable String Id) {

        return eventgroupsService.getEventgroups(Id);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public EventgroupsRespVO add(@RequestBody EventgroupsAddReqVO EventgroupsAddVO) {
        return eventgroupsService.addEventgroups(EventgroupsAddVO);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del")
    public Integer delete(@PathVariable String Id) {
        return eventgroupsService.deleteEventgroups(Id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public EventgroupsRespVO update(@RequestBody EventgroupsUpdateReqVO UpdateReqVO) {
        return eventgroupsService.updateEventgroups(UpdateReqVO);
    }

}
