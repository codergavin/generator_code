package ${package}.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * @author  ${author}
 * @version 1.0
 * @date ${date}
 * Description: [${table.tableDesc}单元测试类]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ${ClassName}ServiceImplTest  {

	@Autowired
	private I${ClassName}Service ${className}Service;

	/**
	* 查询${functionName}
	*/
	@Test
	public void select${ClassName}ById() {
		${ClassName} ${className} = ${className}Service.select${ClassName}ById(1);
		System.out.println(${className}.toString());
	}

	/**
	* 查询${functionName}列表
	*/
	@Test
	public void select${ClassName}List() {
		List<${ClassName}> list = ${className}Service.select${ClassName}List(new ${ClassName}());
		for(${ClassName} model: list){
			System.out.println(model.toString());
		}
	}

	/**
	* 新增${functionName}
	*/
	@Test
	public void insert${ClassName}() {
		for (int i = 1;i < 30; i++) {
			${ClassName} ${className} = new ${ClassName}();
			${className}Service.insert${ClassName}(${className});
		}
	}

	/**
	* 修改${functionName}
	*/
	@Test
	public void update${ClassName}() {
		${ClassName} ${className} = new ${ClassName}();
		${className}Service.update${ClassName}(${className});
	}

	/**
	* 批量删除${functionName}
	*/
	@Test
	public void delete${ClassName}ByIds() {
	}

	/**
	* 删除${functionName}信息
	*/
	@Test
	public void delete${ClassName}ById() {
	}

}
