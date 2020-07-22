package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.ImageCommentEntity;
import com.zdxj.service.ImageCommentService;


@RestController
@RequestMapping("/imageComment")
public class ImageCommentController extends BaseController<ImageCommentService,ImageCommentEntity>{

}
