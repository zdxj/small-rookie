package com.zdxj.core.hystrix;

import java.util.List;
import java.util.Map;

import com.zdxj.core.Page;
import com.zdxj.core.Result;
import com.zdxj.core.entity.BaseEntity;
import com.zdxj.core.feignclient.BaseFeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public class BaseHystrix<T extends BaseEntity> implements BaseFeignClient<T> {
    @Override
    public Result<T> getById(@RequestParam("id") Integer id) {
        return Result.failed();
    }

    @Override
    public Result<Object> save(@RequestBody T entity) {
    	return Result.failed();
    }

    @Override
    public Result<Object> update(@RequestBody T entity) {
    	return Result.failed();
    }


    @Override
    public Result<Object> removeById(@RequestParam("id") Integer id) {
    	return Result.failed();
    }

    @Override
    public Result<Object> removeByIds(@RequestBody List<Integer> ids) {
    	return Result.failed();
    }

    @Override
    public Result<List<T>> list(@RequestBody(required =false) Map<String, Object> maps) {
    	return Result.failed();
    }

    @Override
    public Result<List<T>> listByConditionWithPage(@RequestBody(required =false) Map<String, Object> maps, @RequestParam("startIndex") int startIndex, @RequestParam("pageSize") int pageSize) {
    	return Result.failed();
    }

    @Override
    public Result<Page<List<T>>> listByPage(@RequestBody Map<String, Object> maps, @RequestParam("startIndex") int startIndex, @RequestParam("pageSize") int pageSize) {
    	return Result.failed();
    }

    @Override
    public Result<Object> count(@RequestBody Map<String, Object> maps) {
    	return Result.failed("操作失败",0);
    }

    @Override
    public Result<List<Integer>> listIds(@RequestBody(required =false) Map<String, Object> maps) {
    	return Result.failed();
    }

}
