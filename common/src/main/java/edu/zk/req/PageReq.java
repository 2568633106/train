package edu.zk.req;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//@NotEmpty 用在集合类上面
//@NotBlank 用在String上面
//@NotNull 用在基本类型上
@Data
public class PageReq {
    @NotNull(message = "【页码不能为空】")
    private int page;
    @NotNull(message = "【每条页数不能为空】")
    @Max(value = 100,message = "【每条页数不能超过100】")
    private int size;

}
