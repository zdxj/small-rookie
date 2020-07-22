package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.ImageEntity;
import com.zdxj.service.ImageService;


@RestController
@RequestMapping("/image")
public class ImageController extends BaseController<ImageService,ImageEntity>{

}
