package com.codergavin.generatorcode.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gavin Lee
 * @version 1.0
 * @date 2020-11-06 14:09
 * @desc
 */
public class CommonService {

    protected void startPage(BaseEntity baseEntity) {
        Integer pageNo = baseEntity.getPageNo();
        Integer pageSize = baseEntity.getPageSize();
        if (pageNo != null && pageSize != null) {
            String orderBy = SqlUtil.escapeOrderBySql(baseEntity.getOrderByStr());
            if (orderBy.length() > 0 ) {
                PageHelper.startPage(pageNo, pageSize, orderBy);
            } else {
                PageHelper.startPage(pageNo, pageSize);
            }

        }
    }

    /**
     * 响应请求分页数据
     */
//    protected ReturnResult getDataTable(List<?> list) {
//        ReturnResult returnResult = ReturnResult.success();
//        Map<String, Object> data = new HashMap<>();
//        data.put("data",list);
//        data.put("total",new PageInfo(list).getTotal());
//        returnResult.setData(data);
//        return returnResult;
//    }

}
