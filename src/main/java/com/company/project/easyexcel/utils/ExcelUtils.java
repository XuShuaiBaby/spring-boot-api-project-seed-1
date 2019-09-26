package com.company.project.easyexcel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.company.project.easyexcel.listener.ExcelListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * @description   
 * @author shuai.xu
 * @time 2019/9/25 14:42
*/
public class ExcelUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    public static <T> List<T> importExcel(MultipartFile file, Class<T> pojoClass, Integer sheetNo) throws Exception {
        ExcelListener listener = new ExcelListener();
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            ExcelReader excelReader = EasyExcel.read(inputStream, pojoClass, listener).build();
            ReadSheet readSheet = EasyExcel.readSheet(sheetNo).build();
            excelReader.read(readSheet);
            // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
            excelReader.finish();
        } catch (IOException e) {
            LOGGER.error("IOException",e);
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
        return listener.getData();
    }

    public static <T> List<T> importExcel(String filePath,Class<T> pojoClass,Integer sheetNo){
        ExcelListener listener = new ExcelListener();
        ExcelReader excelReader = EasyExcel.read(filePath, pojoClass, listener).build();
        ReadSheet readSheet = EasyExcel.readSheet(sheetNo).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return listener.getData();
    }
}
