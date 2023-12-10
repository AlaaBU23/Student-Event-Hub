package CS673.SpringBootStudentEventHub.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IEventregistrationsService;
import CS673.SpringBootStudentEventHub.entity.Eventregistrations;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import CS673.SpringBootStudentEventHub.domain.po.EventregistrationsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

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
@RequestMapping("/eventregistrations")
@CrossOrigin(origins = "*")
public class EventregistrationsController {
    @Autowired
    private IEventregistrationsService eventregistrationsService;

    /**
     * search page data
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * get event registration case following the case id
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public EventregistrationsRespVO getById(@PathVariable String Id) {

        return eventregistrationsService.getEventregistrations(Id);
    }

    /**
     * create a new event registration case
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public EventregistrationsRespVO add(@RequestBody EventregistrationsAddReqVO EventregistrationsAddVO) {
        return eventregistrationsService.addEventregistrations(EventregistrationsAddVO);
    }

    /**
     * delete event registration case
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return eventregistrationsService.deleteEventregistrations(Id);
    }

    /**
     * edit / update event registration information
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public EventregistrationsRespVO update(@RequestBody EventregistrationsUpdateReqVO UpdateReqVO) {
        return eventregistrationsService.updateEventregistrations(UpdateReqVO);
    }

}
