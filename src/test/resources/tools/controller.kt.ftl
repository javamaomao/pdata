package ${package.Controller};

import com.jifenkeji.pdata.entity.${entity}
import com.jifenkeji.pdata.service.I${entity}Service
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.set
import org.springframework.web.bind.annotation.PostMapping
import javax.annotation.Resource

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
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if> {
    val BasePath = "<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>"

    @Resource
    lateinit var <#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>Service: I${entity}Service

    /**
    * <p>
    * 显示 ${table.comment!} 中所有项目
    * </p>
    *
    * @author ${author}
    * @since ${date}
    */
    @GetMapping("/")
    fun list(m: Model): Any {

        val datas = <#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>Service.list()

        <#if restControllerStyle>
        return datas
        <#else>
        m.set("datas", datas)
        return "$BasePath/list"
        </#if>
    }

    /**
    * <p>
    * 增加 ${table.comment!} 数据的表单
    * </p>
    *
    * @author ${author}
    * @since ${date}
    */
    @GetMapping("/add")
    fun add(m: Model): Any {
        //
        val data = ${entity}()
        m.set("data", data)

        return "$BasePath/add"
    }

    /**
    * <p>
    * 增加记录到 ${table.comment!} 表中
    * </p>
    *
    * @author ${author}
    * @since ${date}
    */
    @PostMapping("/add_save")
    fun add_save(m: Model, <#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>: ${entity}): Any {

        <#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>Service.save(<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 编辑 ${table.comment!} 的表单
    * </p>
    *
    * @author ${author}
    * @since ${date}
    */
    @GetMapping("/edit")
    fun edit(m: Model, id: Int?): Any {

        //
        val data = <#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>Service.getById(id ?: 1)
        m.set("data", data)

        return "$BasePath/edit"
    }

    /**
    * <p>
    * 保存记录到 ${table.comment!}
    * </p>
    *
    * @author ${author}
    * @since ${date}
    */
    @PostMapping("/edit_save")
    fun edit_save(m: Model, <#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>: ${entity}): Any {

        <#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>Service.updateById(<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>)

        return "redirect:/$BasePath/list"
    }

    /**
    * <p>
    * 删除 ${table.comment!}表中的记录
    * </p>
    *
    * @author ${author}
    * @since ${date}
    */
    @GetMapping("/del")
    fun del(m: Model, id: Int?): Any {
        id ?: return "redirect:/$BasePath/list"

        val datas = <#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>Service.removeById(id)
        m.set("datas", datas)

        return "redirect:/$BasePath/list"
    }
}
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

}
</#if>
