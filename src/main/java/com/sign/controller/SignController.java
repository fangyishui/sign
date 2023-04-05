package com.sign.controller;

import com.sign.dao.SignRepository;
import com.sign.entity.SignReason;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class SignController {

    @Resource
    private SignRepository signRepository;

    @GetMapping ("/")
    public String index(Model model){
        List<SignReason> list = new ArrayList<>();

        SignReason signReason1 = new SignReason();
        signReason1.setId(1);
        signReason1.setReason("上班打卡");
        SignReason signReason2 = new SignReason();
        signReason2.setId(2);
        signReason2.setReason("下班打卡");
        list.add(signReason1);
        list.add(signReason2);

        model.addAttribute("list",list);
        return "index";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(SignReason signReason){
        signReason.setCreateTime(new Date());
        signReason.setUpdateTime(new Date());
        signReason.setCreateUserId(1);
        signReason.setCreateUserName("admin");
        signReason.setUpdateUserId(1);
        signReason.setUpdateUserName("admin");
        SignReason reason = signRepository.save(signReason);
        return reason != null ? "success" : "error";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<SignReason> list(SignReason signReason){
        return signRepository.findAll();
    }
}
