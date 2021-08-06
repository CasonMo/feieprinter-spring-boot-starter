package com.cason.feiePrint.entity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2021/8/6
 * Time: 14:29
 */
public class PrinterAddListFeieReq extends FeieReq{
    private List<AddPrinterDto> addPrinterDtoList;

    public List<AddPrinterDto> getAddPrinterDtoList() {
        return addPrinterDtoList;
    }

    public void setAddPrinterDtoList(List<AddPrinterDto> addPrinterDtoList) {
        this.addPrinterDtoList = addPrinterDtoList;
    }
}
