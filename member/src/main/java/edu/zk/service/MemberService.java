package edu.zk.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import edu.zk.controller.ControllerExceptionHandler;
import edu.zk.domain.Member;
import edu.zk.domain.MemberExample;
import edu.zk.exception.BusinessException;
import edu.zk.exception.BusinessExceptionEnum;
import edu.zk.mapper.MemberMapper;
import edu.zk.req.MemberLoginReq;
import edu.zk.req.MemberRegisterReq;
import edu.zk.req.MemberSendCodeReq;
import edu.zk.resp.MemberLoginResp;
import edu.zk.util.JwtUtil;
import edu.zk.util.SnowUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @Resource
    MemberMapper memberMapper;
    public Long count(){
        return memberMapper.countByExample(null);
    }

    //注册的时候数据库有此号码就报错（已存在）。没有就插入此号码的信息。
    public Long register(MemberRegisterReq mobile){
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile.getMobile());
        List<Member> list = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(list)){
            throw new BusinessException(BusinessExceptionEnum.MEMER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile.getMobile());
        memberMapper.insert(member);
        return member.getId();
    }

    //发送验证码的时候，有此手机号则发送，否则创建手机号并插入信息再发送。
    public void sencode(MemberSendCodeReq req) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(req.getMobile());
        List<Member> list = memberMapper.selectByExample(memberExample);
        if(CollUtil.isEmpty(list)){
            LOG.info("号码不存在，插入号码信息");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(req.getMobile());
            memberMapper.insert(member);
        }
        String code="8888";
//        String code = RandomUtil.randomString(4);
        LOG.info("生成验证码：{}",code);

    }

    public MemberLoginResp login(MemberLoginReq req) {
        String code = req.getCode();
        String mobile = req.getMobile();
        if(!"8888".equals(code)){
            throw new BusinessException(BusinessExceptionEnum.MEMER_CODE_ERROR);
        }
        Member member = selectByMobile(mobile);
        if(member==null){
            throw new BusinessException(BusinessExceptionEnum.MEMER_MOBILE_NOEXIST);
        }

        MemberLoginResp memberLoginResp = BeanUtil.copyProperties(member, MemberLoginResp.class);
        String token = JwtUtil.createToken(member.getId(), member.getMobile());
        memberLoginResp.setToken(token);
        return memberLoginResp;
    }
    public Member selectByMobile(String mobile){
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if(members==null||members.size()==0){
            return null;
        }
        return members.get(0);
    }
}
