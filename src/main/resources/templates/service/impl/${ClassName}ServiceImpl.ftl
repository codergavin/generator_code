package ${package}.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ${package}.model.Page;
import ${package}.dao.${ClassName}Mapper;
import ${package}.model.${ClassName};
import ${package}.service.${ClassName}Service;

/** 
 * @author  ${author}
 * @version 1.0
 * @date ${date}
 * Description: [${table.tableDesc}服务实现]
 */
@Service
public class ${ClassName}ServiceImpl implements ${ClassName}Service {
	@Autowired
	private ${ClassName}Mapper ${className}Mapper;

	/**
	* 查询${functionName}
	*
	* @param ${pkColumn.name} ${functionName}ID
	* @return ${functionName}
	*/
	@Override
	public ${ClassName} select${ClassName}ById(${pkColumn.type} ${pkColumn.name}) {
		return ${className}Mapper.select${ClassName}ById(${pkColumn.name});
	}

	/**
	* 查询${functionName}列表
	*
	* @param ${className} ${functionName}
	* @return ${functionName}
	*/
	@Override
	public List<${ClassName}> select${ClassName}List(${ClassName} ${className}) {
		return ${className}Mapper.select${ClassName}List(${className});
	}

	/**
	* 新增${functionName}
	*
	* @param ${className} ${functionName}
	* @return 结果
	*/
	@Override
	public int insert${ClassName}(${ClassName} ${className}) {
		return ${className}Mapper.insert${ClassName}(${className});
	}

	/**
	* 修改${functionName}
	*
	* @param ${className} ${functionName}
	* @return 结果
	*/
	@Override
	public int update${ClassName}(${ClassName} ${className}) {
		return ${className}Mapper.update${ClassName}(${className});
	}

	/**
	* 批量删除${functionName}
	*
	* @param ${pkColumn.name}s 需要删除的${functionName}ID
	* @return 结果
	*/
	@Override
	public int delete${ClassName}ByIds(${pkColumn.type}[] ${pkColumn.name}s) {
		return ${className}Mapper.delete${ClassName}ByIds(${pkColumn.name}s);
	}

	/**
	* 删除${functionName}信息
	*
	* @param ${pkColumn.name} ${functionName}ID
	* @return 结果
	*/
	@Override
	public int delete${ClassName}ById(${pkColumn.type} ${pkColumn.name}) {
		return ${className}Mapper.delete${ClassName}ById(${pkColumn.name});
	}

}
