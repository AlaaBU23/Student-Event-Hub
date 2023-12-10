package CS673.SpringBootStudentEventHub.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IZipcodesService;
import CS673.SpringBootStudentEventHub.entity.Zipcodes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import CS673.SpringBootStudentEventHub.domain.po.ZipcodesPO;
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
@RequestMapping("/zipcodes")
@CrossOrigin(origins = "*")
public class ZipcodesController {
    @Autowired
    private IZipcodesService zipcodesService;

    /**
     * get page data
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * get zipcode information by id
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public ZipcodesRespVO getById(@PathVariable String Id) {

        return zipcodesService.getZipcodes(Id);
    }

    /**
     * add new zipcode inform
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ZipcodesRespVO add(@RequestBody ZipcodesAddReqVO ZipcodesAddVO) {
        return zipcodesService.addZipcodes(ZipcodesAddVO);
    }

    /**
     * delete zipcode
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return zipcodesService.deleteZipcodes(Id);
    }

    /**
     * update zipcode information
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ZipcodesRespVO update(@RequestBody ZipcodesUpdateReqVO UpdateReqVO) {
        return zipcodesService.updateZipcodes(UpdateReqVO);
    }

}
