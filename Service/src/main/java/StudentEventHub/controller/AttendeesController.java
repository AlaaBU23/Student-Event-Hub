package StudentEventHub.controller;


import StudentEventHub.domain.vo.AttendeesAddReqVO;
import StudentEventHub.domain.vo.AttendeesRespVO;
import StudentEventHub.domain.vo.AttendeesUpdateReqVO;
import StudentEventHub.service.IAttendeesService;
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
@RequestMapping("/attendees")
@CrossOrigin(origins = "*")
public class AttendeesController {
    @Autowired
    private IAttendeesService attendeesService;

    /**
     * get page data
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * get Attendees by userid
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public AttendeesRespVO getById(@PathVariable String Id) {

        return attendeesService.getAttendees(Id);
    }

    /**
     * Add new attendee
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AttendeesRespVO add(@RequestBody AttendeesAddReqVO AttendeesAddVO) {
        return attendeesService.addAttendees(AttendeesAddVO);
    }

    /**
     * delete attendee
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return attendeesService.deleteAttendees(Id);
    }

    /**
     * edit or update attendee information
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public AttendeesRespVO update(@RequestBody AttendeesUpdateReqVO UpdateReqVO) {
        return attendeesService.updateAttendees(UpdateReqVO);
    }

}
