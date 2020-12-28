package ${package}.service;

import java.util.List;

import ${package}.model.${className};

/**
 * @author  ${author}
 * @version 1.0 
 * Created on ${date}
 * Description: [${table.tableDesc}服务]
 */
public interface I${ClassName}Service {

	/**
	* 查询${functionName}
	*
	* @param ${pkColumn.name} ${functionName}ID
	* @return ${functionName}
	*/
	${ClassName} select${ClassName}ById(${pkColumn.type} ${pkColumn.name});

	/**
	* 查询${functionName}列表
	*
	* @param ${className} ${functionName}
	* @return ${functionName}集合
	*/
	List<${ClassName}> select${ClassName}List(${ClassName} ${className});

	/**
	* 新增${functionName}
	*
	* @param ${className} ${functionName}
	* @return 结果
	*/
	int insert${ClassName}(${ClassName} ${className});

	/**
	* 修改${functionName}
	*
	* @param ${className} ${functionName}
	* @return 结果
	*/
	int update${ClassName}(${ClassName} ${className});

	/**
	* 批量删除${functionName}
	*
	* @param ${pkColumn.name}s 需要删除的${functionName}ID
	* @return 结果
	*/
	int delete${ClassName}ByIds(${pkColumn.type}[] ${pkColumn.name}s);

	/**
	* 删除${functionName}信息
	*
	* @param ${pkColumn.name} ${functionName}ID
	* @return 结果
	*/
	int delete${ClassName}ById(${pkColumn.type} ${pkColumn.name});
	
}
