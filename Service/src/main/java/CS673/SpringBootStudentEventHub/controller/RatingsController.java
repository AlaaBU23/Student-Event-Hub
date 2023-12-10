package CS673.SpringBootStudentEventHub.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IRatingsService;
import CS673.SpringBootStudentEventHub.entity.Ratings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import CS673.SpringBootStudentEventHub.domain.po.RatingsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/ratings")
@CrossOrigin(origins = "*")
public class RatingsController {
    @Autowired
    private IRatingsService ratingsService;

    /**
     * get page data
     */
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {

        return null;
    }


    /**
     * get Rating information by id
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
    public RatingsRespVO getById(@PathVariable String Id) {

        return ratingsService.getRatings(Id);
    }

    /**
     * add a new rating case
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RatingsRespVO add(@RequestBody RatingsAddReqVO RatingsAddVO) {
        return ratingsService.addRatings(RatingsAddVO);
    }

    /**
     * delete rating case by id
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del/{Id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String Id) {
        return ratingsService.deleteRatings(Id);
    }

    /**
     * update rating case
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RatingsRespVO update(@RequestBody RatingsUpdateReqVO UpdateReqVO) {
        return ratingsService.updateRatings(UpdateReqVO);
    }

    @ApiOperation(value = "计算评分")
    @RequestMapping(value = "/calculate/{Id}", method = RequestMethod.POST)
    public Double calc(@PathVariable String Id) {
        ratingsService.CalculateRating(Id);
        return 1.0;
    }
}
