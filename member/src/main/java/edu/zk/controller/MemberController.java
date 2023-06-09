package edu.zk.controller;

import edu.zk.req.MemberLoginReq;
import edu.zk.req.MemberRegisterReq;
import edu.zk.req.MemberSendCodeReq;
import edu.zk.resp.CommonResp;
import edu.zk.resp.MemberLoginResp;
import edu.zk.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    MemberService memberService;
    @GetMapping("/hello")
    public CommonResp<Integer> test(){
        CommonResp<Integer> commonResp = new CommonResp<>();
        commonResp.setContent(memberService.count());
        return commonResp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq mobile){
        return new CommonResp( memberService.register(mobile));
    }

    @PostMapping("/send-code")
    public CommonResp<Object> sendcode(@Valid @RequestBody MemberSendCodeReq req){
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req){
        return new CommonResp<>(memberService.login(req));
    }
}
