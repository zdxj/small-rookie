package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.ImageCategoryEntity;
import com.zdxj.service.ImageCategoryService;


@RestController
@RequestMapping("/imageCategory")
public class ImageCategoryController extends BaseController<ImageCategoryService,ImageCategoryEntity>{

}
