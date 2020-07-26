package com.zdxj.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zdxj.core.Result;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.ImageCommentEntity;
import com.zdxj.model.MemberEntity;
import com.zdxj.model.MemberLevelEntity;
import com.zdxj.service.ImageCommentService;
import com.zdxj.service.MemberLevelService;
import com.zdxj.service.MemberService;


@RestController
@RequestMapping("/imageComment")
public class ImageCommentController extends BaseController<ImageCommentService,ImageCommentEntity>{

	@Autowired
	private ImageCommentService myService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberLevelService memberLevelService;
	
	/**
	 * 图片评论信息
	 * @param imageId
	 * @return
	 */
	@GetMapping("listComment")
	public Result<Map<String,Object>> listComment(@RequestParam("id") Integer imageId){
		
		Map<String,Object> result = Maps.newHashMap();
		//最新评论
		Map<String,Object> maps = Maps.newHashMap();
		maps.put("imageId", imageId);
		maps.put("orderBy", "id,desc");
		List<ImageCommentEntity> newList = myService.listByConditionWithPage(maps, 0, 3);
		List<Map<String,Object>> commentList = Lists.newArrayList();
		if(CollectionUtils.isNotEmpty(newList)) {
			Map<String,Object> resultNew = null ;
			for(ImageCommentEntity info:newList) {
				resultNew = Maps.newHashMap();
				resultNew.put("comment", info);
				MemberEntity member = memberService.getById(info.getMemberId());
				if(member != null) {
					MemberLevelEntity level = memberLevelService.getById(member.getLevelId());
					resultNew.put("level", level);
				}
				resultNew.put("member", member);
				commentList.add(resultNew);
			}
		}
		result.put("commentList", commentList);
		//最热评论
		maps.clear();
		maps.put("imageId", imageId);
		maps.put("orderBy", "support_count,desc;id,desc");
		List<ImageCommentEntity> hotList = myService.listByConditionWithPage(maps, 0, 3);
		List<Map<String,Object>> hotResult = Lists.newArrayList();
		if(CollectionUtils.isNotEmpty(hotList)) {
			Map<String,Object> resultHot = null ;
			for(ImageCommentEntity info:hotList) {
				resultHot = Maps.newHashMap();
				resultHot.put("comment", info);
				MemberEntity member = memberService.getById(info.getMemberId());
				if(member != null) {
					MemberLevelEntity level = memberLevelService.getById(member.getLevelId());
					resultHot.put("level", level);
				}
				resultHot.put("member", member);
				hotResult.add(resultHot);
			}
		}
		result.put("hotList", hotResult);
		return Result.success(result);
	}
}
