package com.company.project.web;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.company.project.easyexcel.listener.ExcelListener;
import com.company.project.easyexcel.model.DemoData;
import com.company.project.easyexcel.model.PersonData;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

@SpringBootTest
public class ExcelTest {

    @Test
    public void simpleRead() {
        // 写法1：
        //String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        File file = new File("E:/工作/Excel/demo.xlsx");
//        System.out.println(file.getName()+file.getPath());
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        //EasyExcel.read(file.getPath(), DemoData.class, new DemoDataListener()).sheet().doRead();

        // 写法2：
        //fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        File file = new File("E:/工作/Excel/demo1.xlsx");
        ExcelListener demoDataListener = new ExcelListener();
        ExcelReader excelReader = EasyExcel.read(file.getPath(), PersonData.class, demoDataListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        List<DemoData> data = demoDataListener.getData();
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }
}
