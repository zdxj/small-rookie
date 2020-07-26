package com.zdxj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.zdxj.core.Result;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.AdEntity;
import com.zdxj.model.ImageCategoryEntity;
import com.zdxj.model.ImageEntity;
import com.zdxj.service.AdService;
import com.zdxj.service.ImageCategoryService;
import com.zdxj.service.ImageService;


@RestController
@RequestMapping("/ad")
public class AdController extends BaseController<AdService,AdEntity>{

	@Autowired
	private AdService myService ;
	@Autowired
	private ImageCategoryService imageCategoryService ;
	@Autowired
	private ImageService imageService ;
	
	/**
	 * 获取首页推荐内容
	 * @param type
	 * @param pageSize
	 * @return
	 */
	@GetMapping("listRecomment")
    public Result<Map<String,Object>> listRecomment(){
        Map<String,Object> result = Maps.newHashMap();
        //首页广告
        Map<String,Object> maps = Maps.newHashMap();
        maps.put("adPosition", "index_top");
        maps.put("orderBy", "position,asc;id,desc");
        List<AdEntity> adList = myService.listByConditionWithPage(maps, 0, 4);
        result.put("adList", adList);
        //负责美丽模块
        Map<String,Object> beautifulMap = Maps.newHashMap();
        ImageCategoryEntity category = imageCategoryService.getById(4);
        maps.clear();
        maps.put("categoryId", category.getId());
        maps.put("orderBy", "position,asc;id,desc");
        List<ImageEntity> images = imageService.listByConditionWithPage(maps, 0, 6);
        beautifulMap.put("title", category.getName());
        beautifulMap.put("addTime", category.getCreateTime());
        beautifulMap.put("images", images);
        result.put("beautiful", beautifulMap);
    	return Result.success(result);
    }
	
	/**
	 * 根据广告位编码获取广告
	 * @param type
	 * @return
	 */
	@GetMapping("listAd")
	public Result<List<AdEntity>> listAd(@RequestParam("type") String type){
		//首页广告
		Map<String,Object> maps = Maps.newHashMap();
		maps.put("adPosition", type);
		maps.put("orderBy", "position,asc;id,desc");
		List<AdEntity> adList = myService.listByCondition(maps);
		return Result.success(adList);
	}
	
}
