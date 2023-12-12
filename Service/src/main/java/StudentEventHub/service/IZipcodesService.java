package StudentEventHub.service;

import StudentEventHub.domain.vo.ZipcodesAddReqVO;
import StudentEventHub.domain.vo.ZipcodesBatchReqVO;
import StudentEventHub.domain.vo.ZipcodesRespVO;
import StudentEventHub.domain.vo.ZipcodesUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.ZipcodesPO;
import StudentEventHub.domain.vo.*;

/**
 * <p>
 * $!{table.comment} service class
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