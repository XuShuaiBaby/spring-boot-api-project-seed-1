package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.core.ResultList;
import com.company.project.model.UserBaseInfo;
import com.company.project.service.ThreadDemoService;
import com.company.project.service.UserBaseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/12/21.
*/
@RestController
//@RequestMapping("/user/base/info")
@Api(value = "User API接口", tags = "user", description = "User API接口")
public class UserBaseInfoController {
    @Resource
    private UserBaseInfoService userBaseInfoService;

    @Autowired
    private ThreadDemoService threadDemoService;

    @PostMapping("/add")
    public Result add(UserBaseInfo userBaseInfo) {
        userBaseInfoService.save(userBaseInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userBaseInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(UserBaseInfo userBaseInfo) {
        userBaseInfoService.update(userBaseInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserBaseInfo userBaseInfo = userBaseInfoService.findById(id);
        return ResultGenerator.genSuccessResult(userBaseInfo);
    }

    @ApiOperation(value = "用户列表", notes = "用户信息查询接口")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserBaseInfo> list = userBaseInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(ResultList.genResultList(pageInfo));
    }

    @ApiOperation(value = "线程测试接口")
    @GetMapping("/test/thread")
    public Result testThread() {
        threadDemoService.strat();
        return ResultGenerator.genSuccessResult();
    }
}
