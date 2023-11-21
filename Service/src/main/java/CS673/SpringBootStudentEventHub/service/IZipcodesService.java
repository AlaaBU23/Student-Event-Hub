package CS673.SpringBootStudentEventHub.service;

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.ZipcodesPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Zipcodes;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.ZipcodesMapper;

/**
 * <p>
 * $!{table.comment} 服务类
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IZipcodesService extends IService<ZipcodesPO> {
    public ZipcodesRespVO getZipcodes(String id);

    public Integer deleteZipcodes(String id);

    public ZipcodesRespVO addZipcodes(ZipcodesAddReqVO ZipcodesAddVO);

    public ZipcodesRespVO updateZipcodes(ZipcodesUpdateReqVO Zipcodes_UpdateReqVO);

    public Integer deleteZipcodesList(ZipcodesBatchReqVO Zipcodes_BatchReqVO);

}