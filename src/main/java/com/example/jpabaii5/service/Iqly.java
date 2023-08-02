package com.example.jpabaii5.service;

import com.example.jpabaii5.model.Congthuc;
import com.example.jpabaii5.model.Loaimonan;
import com.example.jpabaii5.model.Monan;

import java.util.Set;

public interface Iqly {
    public Monan themMonan(Monan monan);
    public Congthuc themCongthuc(Congthuc congthuc);
    public Loaimonan xoaLoaimonan(int loaimonanID);
    public Set<Monan> timKiemMonan(String Tenmonan, String Tennguyenlieu);
}
