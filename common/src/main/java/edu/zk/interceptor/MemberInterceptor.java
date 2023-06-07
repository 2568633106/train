package edu.zk.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import edu.zk.context.LoginMemberContext;
import edu.zk.resp.MemberLoginResp;
import edu.zk.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//每次登录时进行拦截，从token中取出登录的member信息放入本地线程中。
//存入的信息包括id、memberid、token
@Component
public class MemberInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(MemberInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token!=null&&!token.isEmpty()){
            LOG.info("获取会员登录token{}",token);
            JSONObject jsonObject = JwtUtil.getJSONObject(token);
            LOG.info("登录会员{}",jsonObject);
            MemberLoginResp memberLoginResp = BeanUtil.copyProperties(jsonObject, MemberLoginResp.class);
            LoginMemberContext.setMember(memberLoginResp);
        }
        return true;
    }
}
