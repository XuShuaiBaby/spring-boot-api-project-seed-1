package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.easyexcel.model.PersonData;
import com.company.project.easyexcel.model.PersonData1;
import com.company.project.easyexcel.utils.ExcelUtils;
import com.company.project.easyexcel.utils.FileUtil;
import com.company.project.service.ExcelService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/import/easy-excel")
    public Result importExcel(@RequestParam MultipartFile newCarFile) {
        List<PersonData> personData = null;
        try {
            long start = System.currentTimeMillis();
            personData = ExcelUtils.importExcel(newCarFile, PersonData.class, 0);
            long end = System.currentTimeMillis();
            System.out.println("耗时"+(end-start));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //excelService.importExcel(personData);
        return ResultGenerator.genSuccessResult(personData);
    }

    @PostMapping("/import/easy-poi")
    public Result importExcelByPoi(@RequestParam MultipartFile newCarFile) {
        List<PersonData1> personData1 = null;
        try {
            long start = System.currentTimeMillis();
            personData1 = FileUtil.importExcel(newCarFile,0,1, PersonData1.class);
            long end = System.currentTimeMillis();
            System.out.println("耗时"+(end-start));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //excelService.importExcel(personData1);
        return ResultGenerator.genSuccessResult(personData1);
    }
}
