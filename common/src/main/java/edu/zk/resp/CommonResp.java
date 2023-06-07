package edu.zk.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResp<T> {
    private boolean success=true;
    private String message;
    private T content;

    public CommonResp(String message) {
        this.message = message;
    }

    public CommonResp(T content) {
        this.content = content;
    }
}
