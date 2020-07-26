package com.zdxj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.zdxj.core.Result;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.ImageEntity;
import com.zdxj.service.ImageService;


@RestController
@RequestMapping("/image")
public class ImageController extends BaseController<ImageService,ImageEntity>{

	@Autowired
	private ImageService myService ;
	
	/**
	 * 首页获取热门模块
	 * @param request
	 * @param maps
	 * @return
	 */
	@GetMapping("listImage")
	public Result<List<ImageEntity>> listImage(HttpServletRequest request,@RequestParam Map<String,Object> maps){
		maps.put("startIndex", Integer.valueOf((String)maps.get("startIndex")));
		maps.put("pageSize", Integer.valueOf((String)maps.get("pageSize")));
		if(maps.containsKey("order")) {
			maps.put("orderBy", maps.get("order")+",desc;id,desc");
			maps.remove("order");
		}else {
			maps.put("orderBy", "position,asc;id,desc");
		}
		return Result.success(myService.listByCondition(maps));
	}
	
	/**
	 * 图片详情
	 * @param request
	 * @param id
	 * @return
	 */
	@GetMapping("detail")
	public Result<Map<String,Object>> detail(HttpServletRequest request,@RequestParam Map<String,Object> maps){
		ImageEntity image = myService.getById(Integer.valueOf((String)maps.get("id")));
		if(image== null) {
			return Result.failed("暂无数据");
		}
		//图片所属的分类
		Map<String,Object> imageMaps = Maps.newHashMap();
		imageMaps.put("categoryId", image.getCategoryId());
		imageMaps.put("startIndex", Integer.valueOf((String)maps.get("startIndex")));
		imageMaps.put("pageSize", Integer.valueOf((String)maps.get("pageSize")));
		imageMaps.put("orderBy", "position,asc;id,desc");
		List<ImageEntity> images = myService.listByCondition(imageMaps);
		//返回结果
		Map<String,Object> result = Maps.newHashMap();
		result.put("image", image);
		result.put("imageList", images);
		return Result.success(result);
	}
}
