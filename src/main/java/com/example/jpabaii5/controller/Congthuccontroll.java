package com.example.jpabaii5.controller;

import com.example.jpabaii5.model.Congthuc;
import com.example.jpabaii5.model.Monan;
import com.example.jpabaii5.service.Iqly;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class Congthuccontroll {
@Autowired
private Iqly monanService;
    private Gson gson = new Gson();
    @PostMapping(value = "monan/them")
    public String themMonan(@RequestBody String data){
        if(monanService.themMonan(gson.fromJson(data, Monan.class))==null)
            return "Them That bai";
        return "Thanh cong";
    }
    @PostMapping(value = "congthuc/them")
    public String themCongthuc(@RequestBody String data){
        if(monanService.themCongthuc(gson.fromJson(data, Congthuc.class))==null)
            return "Them That bai";
        return "Them thanh cong";
    }
    @DeleteMapping(value = "loaimon/xoa")
    public String xoaLoaimonan(@RequestParam int LoaimonanID){
        if(monanService.xoaLoaimonan(LoaimonanID)==null)
            return "Xoa that bai";
        return "Xoa thanh cong";
    }
    @GetMapping(value = "monan/lay")
    public Set<Monan> xoaLoaimonan(@RequestParam String Tenmon, @RequestParam String Tennguyenlieu){
        Set<Monan> monans = monanService.timKiemMonan(Tenmon,Tennguyenlieu);
        return monans;
    }
}
