package com.zdxj.core.feignclient;

import java.util.List;
import java.util.Map;

import com.zdxj.core.Page;
import com.zdxj.core.Result;
import com.zdxj.core.entity.BaseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zhaodx
 * @Date 2019/6/22 20:16
 */
public interface BaseFeignClient<T extends BaseEntity> {

    @GetMapping("getById")
    Result<T> getById(@RequestParam("id") Integer id);

    @PostMapping("saveEntity")
    Result<Object> saveEntity(@RequestBody T entity);

    @PostMapping("updateEntity")
    Result<Object> updateEntity(@RequestBody T entity);

    @GetMapping("deleteById")
    Result<Object> deleteById(@RequestParam("id") Integer id);

    @PostMapping("deleteByIds")
    Result<Object> deleteByIds(@RequestBody List<Integer> ids);

    @PostMapping("listAll")
    Result<List<T>> listAll();

    @PostMapping("listByCondition")
    Result<List<T>> listByCondition(@RequestBody Map<String, Object> maps);

    @PostMapping("listByConditionWithPage")
    Result<List<T>> listByConditionWithPage(@RequestBody Map<String, Object> maps, @RequestParam("startIndex") int startIndex, @RequestParam("pageSize") int pageSize);

    @PostMapping("listByPage")
    Result<Page<List<T>>> listByPage(@RequestBody Map<String, Object> maps, @RequestParam("startIndex") int startIndex, @RequestParam("pageSize") int pageSize);

    @PostMapping("countAll")
    Result<Object> countAll();
    
    @PostMapping("countByCondition")
    Result<Object> countByCondition(@RequestBody Map<String, Object> maps);

    @PostMapping("listIds")
    Result<List<Integer>> listIds(@RequestBody Map<String, Object> maps);
}
