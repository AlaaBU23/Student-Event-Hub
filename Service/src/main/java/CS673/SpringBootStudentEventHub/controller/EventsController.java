package CS673.SpringBootStudentEventHub.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IEventsService;
import CS673.SpringBootStudentEventHub.entity.Events;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import CS673.SpringBootStudentEventHub.domain.po.EventsPO;
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
@RequestMapping("/events")
@CrossOrigin(origins = "*")
public class EventsController {
    @Autowired
    private IEventsService eventsService;

    /**
     * 查询分页数据
     * search page data
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * 根据id查询
     * get event information following event id
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public EventsRespVO getById(@PathVariable String Id) {

        return eventsService.getEvents(Id);
    }

    /**
     * 新增
     * create an event by host
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public EventsRespVO add(@RequestBody EventsAddReqVO EventsAddVO) {
        return eventsService.addEvents(EventsAddVO);
    }

    /**
     * 删除
     * delete an event
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return eventsService.deleteEvents(Id);
    }

    /**
     * 修改
     * edit / update event information
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public EventsRespVO update(@RequestBody EventsUpdateReqVO UpdateReqVO) {
        return eventsService.updateEvents(UpdateReqVO);
    }

}
