package com.company.project.service.impl;

import com.company.project.easyexcel.model.PersonData;
import com.company.project.service.ExcelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public void importExcel(List<PersonData> personData) {
    }
}
