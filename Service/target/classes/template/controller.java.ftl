package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.${table.serviceName};
import CS673.SpringBootStudentEventHub.entity.${entity};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import CS673.SpringBootStudentEventHub.domain.po.${entity}PO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import java.util.List;
<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
* <p>
    * ${table.comment!} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
* @version v1.0
*/
<#if restControllerStyle>
    @Api(tags = {"${table.comment!}"})
    @RestController
<#else>
    @Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
    public class ${table.controllerName} extends ${superControllerClass} {
<#else>
    public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

/**
* 查询分页数据
*/
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list")
    public Page findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){

    return null;
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById")
    public ${entity}RespVO getById(@PathVariable String Id){

    return ${(table.serviceName?substring(1))?uncap_first}.get${entity}(Id);
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ${entity}RespVO add(@RequestBody ${entity}AddReqVO ${entity}AddVO){
    return ${(table.serviceName?substring(1))?uncap_first}.add${entity}(${entity}AddVO);
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del")
    public Integer delete(@PathVariable String Id){
    return ${(table.serviceName?substring(1))?uncap_first}.delete${entity}(Id);
    }

    /**
    * 修改
    */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ${entity}RespVO update(@RequestBody ${entity}UpdateReqVO UpdateReqVO){
    return ${(table.serviceName?substring(1))?uncap_first}.update${entity}(UpdateReqVO);
    }

    }
</#if>