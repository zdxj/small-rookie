package com.zdxj.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdxj.core.Page;
import com.zdxj.core.Result;
import com.zdxj.core.entity.BaseEntity;
import com.zdxj.core.service.BaseService;

public class BaseController<M extends BaseService<T>,T extends BaseEntity> {

	@Autowired
    private M myService;

	
	public M getMyService() {
		return myService;
	}

	public void setMyService(M myService) {
		this.myService = myService;
	}

	/**
     * 根据id获取对象
     * @param id
     * @return
     */
    @GetMapping("getById")
    public Result<T> getById(@RequestParam("id") Integer id){
        return Result.success(myService.getById(id));
    }

    /**
     * 保存对象
     * @param entity
     * @return
     */
    @PostMapping("save")
    public Result<Object> save(@RequestBody T entity){
        return Result.success(myService.saveEntity(entity));
    }

    /**
     * 更新对象
     * @param entity
     * @return
     */
    @PostMapping("update")
    public Result<Object> update(@RequestBody T entity){
    	myService.updateEntity(entity);
        return Result.success(entity.getId());
    }

    /**
     * 根据UUID删除对象
     * @param id
     * @return
     */
    @GetMapping("removeById")
    public Result<Object> removeById(@RequestParam("id") Integer id){
        return Result.success(myService.deleteById(id));
    }

    /**
     * 根据UUID集合删除对象
     * @param list
     * @return
     */
    @PostMapping("removeByIds")
    public Result<Object> removeByIds(@RequestBody List<Integer> list){
        return Result.success(myService.deleteByIds(list));
    }

    /**
     * 根据条件获取集合
     * @param maps
     * @return
     */
    @PostMapping("list")
    public Result<List<T>> list(@RequestBody(required =false) Map<String, Object> maps){
        return Result.success(myService.listByCondition(maps));
    }

    /**
     * 分页获取对象集合
     * @param maps
     * @param firstResultIndex
     * @param pageSize
     * @return
     */
    @PostMapping("listByPage")
    public Result<Page<List<T>>> listByPage(@RequestBody Map<String, Object> maps){
        if(!maps.containsKey("startIndex")) {
        	return Result.failed("startIndex不能为空");
        }
        if(!maps.containsKey("pageSize")) {
        	return Result.failed("pageSize不能为空");
        }
    	return Result.success(myService.listByPage(maps, (Integer)maps.get("startIndex"), (Integer)maps.get("pageSize")));
    }
    
    /**
     * 根据条件获取集合数量
     * @param maps
     * @return
     */
    @PostMapping("count")
    public Result<Object> count(@RequestBody(required =false) Map<String, Object> maps){
        return Result.success(myService.countByCondition(maps));
    }
    
    /**
     * 根据条件获取对象UUID集合
     * @param maps
     * @return
     */
    @PostMapping("listIds")
    public Result<List<Integer>> listIds(@RequestBody(required =false) Map<String, Object> maps){
        return Result.success(myService.listIds(maps));
    }
  
}
