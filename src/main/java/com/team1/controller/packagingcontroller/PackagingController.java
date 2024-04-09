package com.team1.controller.packagingcontroller;

import com.team1.model.entity.PackagingEntity;
import com.team1.service.packagingservice.PackagingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/packaging")
public class PackagingController {
    @Autowired
    private PackagingService packagingService;

    @GetMapping("/info/get.do")
    public List<Object> doPackInfoGet(@RequestParam int pgno){
        System.out.println("PackagingController.doPackInfoGet");
        System.out.println("★pgno = " + pgno);
        return packagingService.doPackInfoGet(pgno);
    }

    @PostMapping("/member/post.do")
    public boolean doMemberPost(){
        System.out.println("PackagingController.doMemberPost");
        return packagingService.doMemberPost();
    }

}
