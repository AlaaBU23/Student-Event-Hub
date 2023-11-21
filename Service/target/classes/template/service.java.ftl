package ${package.Service};

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.${entity}PO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.${entity};
import ${superServiceClassPackage};
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.${entity}Mapper;

/**
* <p>
    * $!{table.comment} 服务类
    * </p>
*
* @author ${author}
* @since ${date}
*/
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
</#if>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}PO> {
    public ${entity}RespVO get${entity}(String id);

    public Integer delete${entity}(String id);

    public ${entity}RespVO add${entity}(${entity}AddReqVO ${entity}AddVO);

    public ${entity}RespVO update${entity}(${entity}UpdateReqVO ${entity}_UpdateReqVO);

    public Integer delete${entity}List(${entity}BatchReqVO ${entity}_BatchReqVO);

}