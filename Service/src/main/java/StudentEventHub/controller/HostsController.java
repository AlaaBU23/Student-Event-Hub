package StudentEventHub.controller;


import StudentEventHub.domain.vo.HostsAddReqVO;
import StudentEventHub.domain.vo.HostsRespVO;
import StudentEventHub.domain.vo.HostsUpdateReqVO;
import StudentEventHub.service.IHostsService;
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
@RequestMapping("/hosts")
@CrossOrigin(origins = "*")
public class HostsController {
    @Autowired
    private IHostsService hostsService;

    /**
     * get page data
     *
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * get host information by userId
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public HostsRespVO getById(@PathVariable String Id) {

        return hostsService.getHosts(Id);
    }

    /**
     * add new host
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HostsRespVO add(@RequestBody HostsAddReqVO HostsAddVO) {
        return hostsService.addHosts(HostsAddVO);
    }

    /**
     * delete host
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}",method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return hostsService.deleteHosts(Id);
    }

    /**
     * update host information
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public HostsRespVO update(@RequestBody HostsUpdateReqVO UpdateReqVO) {
        return hostsService.updateHosts(UpdateReqVO);
    }

}
