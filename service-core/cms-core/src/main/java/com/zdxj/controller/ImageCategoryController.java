package com.zdxj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zdxj.core.Result;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.ImageCategoryEntity;
import com.zdxj.service.ImageCategoryService;


@RestController
@RequestMapping("/imageCategory")
public class ImageCategoryController extends BaseController<ImageCategoryService,ImageCategoryEntity>{

	@Autowired
	private ImageCategoryService myService ;
	
	/**
	 * 获取分类列表
	 * @param request
	 * @param maps
	 * @return
	 */
	@GetMapping("listCategory")
	public Result<List<ImageCategoryEntity>> listCategory(HttpServletRequest request,@RequestParam Map<String,Object> maps){
		maps.put("startIndex", Integer.valueOf((String)maps.get("startIndex")));
		maps.put("pageSize", Integer.valueOf((String)maps.get("pageSize")));
		maps.put("orderBy", "position,asc;id,asc");
		return Result.success(myService.listByCondition(maps));
	}
}
