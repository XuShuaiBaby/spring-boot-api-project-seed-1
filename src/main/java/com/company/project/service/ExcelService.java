package com.company.project.service;

import com.company.project.easyexcel.model.PersonData;

import java.util.List;

public interface ExcelService {

    void importExcel(List<PersonData> personData);
}
