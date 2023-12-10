package ${package.ServiceImpl};


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import CS673.SpringBootStudentEventHub.domain.po.${entity}PO;
import CS673.SpringBootStudentEventHub.tools.*;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.${table.serviceName};
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import CS673.SpringBootStudentEventHub.mapper.${entity}Mapper;
/**
* @author ${author}
* @date ${date}
*
*/
<#if kotlin>
    interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
</#if>
@Service
@Slf4j
public class ${entity}ServiceImpl extends ServiceImpl<${entity}Mapper, ${entity}PO> implements I${entity}Service {

    @Autowired
    private ${entity}Mapper ${entity}_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1,1,1);

    @Override
    public ${entity}RespVO get${entity}(String id) {
        ${entity}RespVO vo = new ${entity}RespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<${entity}PO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            vo = toVO(${entity}_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer delete${entity}(String id){

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
        QueryWrapper<${entity}PO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            deleteCount = ${entity}_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
    * add ${entity}
    *
    * @param ${entity}AddVO
    * @return ${entity}RespVO
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ${entity}RespVO add${entity}(${entity}AddReqVO ${entity}AddVO) {
        ${entity}RespVO vo = new ${entity}RespVO();
        if (${entity}AddVO != null) {
            fillingAddParams(${entity}AddVO);
            ${entity}PO po = fromReqVO(${entity}AddVO);
            ${entity}_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
    * update ${entity}
    *
    * @param ${entity}_UpdateReqVO
    * @return ${entity}RespVO
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ${entity}RespVO update${entity}(${entity}UpdateReqVO ${entity}_UpdateReqVO) {
        ${entity}RespVO vo = new ${entity}RespVO();
        if (${entity}_UpdateReqVO != null) {
            fillingUpdateParams(${entity}_UpdateReqVO);
            QueryWrapper<${entity}PO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("${entity}Id", ${entity}_UpdateReqVO.get${entity}Id());
            ${entity}PO po = fromReqVO(${entity}_UpdateReqVO);
            ${entity}_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
    * delete amount of ${entity}
    *
    * @param ${entity}_BatchReqVO
    * @return number of success deletes
    */ 
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer delete${entity}List(${entity}BatchReqVO ${entity}_BatchReqVO) {
        Integer deleteCount = 0;
        if (${entity}_BatchReqVO != null) {
            List<String> ids = ${entity}_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<${entity}PO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("${entity}Id", ids);
                deleteCount = ${entity}_Mapper.delete(queryWrapper);
            }
        }
        return deleteCount;
    }
    /**
    * addReqVO转po
    * @param queryVO
    * @return po
    */
    private ${entity}PO fromReqVO(${entity}AddReqVO queryVO) {
        ${entity}PO po = new ${entity}PO();
        if (queryVO != null) {
            BeanUtils.copyProperties(queryVO, po);
        }
        return po;
    }

    /**
    * updateReq转po
    *
    * @param queryVO
    * @return po
    */
    private ${entity}PO fromReqVO(${entity}UpdateReqVO queryVO) {
    ${entity}PO po = new ${entity}PO();
        if (queryVO != null) {
            BeanUtils.copyProperties(queryVO, po);
        }
        return po;
    }


    /**
    * po转vo
    *
    * @param po
    * @return vo
    */
    private ${entity}RespVO toVO(${entity}PO po) {
        ${entity}RespVO vo = new ${entity}RespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
    *
    * @param queryVO
    * @return
    */
    private void fillingAddParams(${entity}AddReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.get${entity}Id())) {
            queryVO.set${entity}Id(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
    * @param queryVO
    * @return
    */
    private void fillingUpdateParams(${entity}UpdateReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.get${entity}Id())) {
            queryVO.set${entity}Id(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}