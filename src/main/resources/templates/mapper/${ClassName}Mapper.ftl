package ${package}.mapper;

import ${package}.model.${ClassName};
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
  * @author  ${author}
  * @version 1.0
  * @date ${date}
  * Description: [${table.tableDesc}服务实现]
 */
public interface ${ClassName}Mapper{

	/**
	* 查询${functionName}
	*
	* @param ${pkColumn.name } ${functionName}ID
	* @return ${functionName}
	*/
	public ${ClassName} select${ClassName}ById(${pkColumn.type} ${pkColumn.name});

	/**
	* 查询${functionName}列表
	*
	* @param ${className} ${functionName}
	* @return ${functionName}集合
	*/
	public List<${ClassName}> select${ClassName}List(${ClassName} ${className});

	/**
	* 新增${functionName}
	*
	* @param ${className} ${functionName}
	* @return 结果
	*/
	public int insert${ClassName}(${ClassName} ${className});

	/**
	* 修改${functionName}
	*
	* @param ${className} ${functionName}
	* @return 结果
	*/
	public int update${ClassName}(${ClassName} ${className});

	/**
	* 删除${functionName}
	*
	* @param ${pkColumn.name } ${functionName}ID
	* @return 结果
	*/
	public int delete${ClassName}ById(${pkColumn.type} ${pkColumn.name});

	/**
	* 批量删除${functionName}
	*
	* @param ${pkColumn.name }s 需要删除的数据ID
	* @return 结果
	*/
	public int delete${ClassName}ByIds(${pkColumn.type}[] ${pkColumn.name}s);

}
