package edu.zk.controller.admin;

import edu.zk.req.TrainQueryReq;
import edu.zk.req.TrainSaveReq;
import edu.zk.resp.CommonResp;
import edu.zk.resp.PageResp;
import edu.zk.resp.TrainQueryResp;
import edu.zk.service.TrainSeatService;
import edu.zk.service.TrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/train")
public class TrainAdminController {

    @Resource
    private TrainService trainService;
    @Autowired
    TrainSeatService trainSeatService;


    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody TrainSaveReq req) {
        trainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainQueryResp>> queryList(@Valid TrainQueryReq req) {
        PageResp<TrainQueryResp> list = trainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        trainService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/query-all")
    public CommonResp<List<TrainQueryResp>> queryAllStation(){
        return trainService.queryAllStation();
    }

    @GetMapping("/gen-seat/{code}")
    public CommonResp getSeatByCode(@PathVariable String code){
        trainSeatService.saveSeatByCode(code);
        return new CommonResp();
    }
}
