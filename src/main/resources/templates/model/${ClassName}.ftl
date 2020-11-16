package ${package}.model;

import java.io.Serializable;
/**
  * @author  ${author}
  * @version 1.0
  * @date ${date}
  * Description: [${table.tableDesc}服务实现]
 */
public class ${ClassName}  implements Serializable {

	private static final long serialVersionUID = 1L;

<#list table.columns as column>
	/**
     * ${column.label}
     */
	private ${column.type} ${column.name};
</#list>
	
	// setter and getter
<#list table.columns as column>
	/**
	* ${column.label}
	* @return ${column.type}
    */
	public ${column.type} get${column.nameUpper}(){
		return ${column.name};
	}
	/**
	* ${column.label}
	*/
	public void set${column.nameUpper}(${column.type} ${column.name}){
		this.${column.name} = ${column.name};
	}
</#list>
}
