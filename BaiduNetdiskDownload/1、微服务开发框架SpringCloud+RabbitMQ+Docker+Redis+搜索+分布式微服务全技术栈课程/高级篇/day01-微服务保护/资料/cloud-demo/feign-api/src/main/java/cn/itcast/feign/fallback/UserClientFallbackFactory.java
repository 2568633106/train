package cn.itcast.feign.fallback;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Bean;

public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(Long id) {
//                throw new NullPointerException("查询用户异常");
//                log.error("查询用户异常", throwable);
                System.out.println("查询用户异常");
                System.out.println(throwable);
                return new User();
            }
        };
    }
}
