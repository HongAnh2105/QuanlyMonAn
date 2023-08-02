package com.example.jpabaii5.service;

import com.example.jpabaii5.model.Congthuc;
import com.example.jpabaii5.model.Loaimonan;
import com.example.jpabaii5.model.Monan;
import com.example.jpabaii5.model.Nguyenlieu;
import com.example.jpabaii5.repository.Conthucrepo;
import com.example.jpabaii5.repository.Loaimonanrepo;
import com.example.jpabaii5.repository.Monanrepo;
import com.example.jpabaii5.repository.Nguyenlieurepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class Qly implements Iqly{
    @Autowired
    private Conthucrepo congthucRepo;
    @Autowired
    private Loaimonanrepo loaimonanRepo;
    @Autowired
    private Monanrepo monanRepo;
    @Autowired
    private Nguyenlieurepo nguyenlieuRepo;

    @Override
    public Monan themMonan(Monan monan) {
        if(loaimonanRepo.findById(monan.getLoaimonan().getLoaimonanid()).isEmpty())
            return null;
        monanRepo.save(monan);
        return monan;
    }
    @Override
    public Congthuc themCongthuc(Congthuc congthuc) {
        Optional<Monan> monan = monanRepo.findById(congthuc.getMonan().getMonanid());
        Optional<Nguyenlieu> nguyenlieu= nguyenlieuRepo.findById(congthuc.getNguyenlieu().getNguyenlieuid());
        if(nguyenlieu.isEmpty() ||nguyenlieu.isEmpty())
            return null;
        monan.get().setCachlam(nguyenlieu.get().getTennguyenlieu()+":"+congthuc.getSoluong()+ " "+ congthuc.getDonvitinh());
        monanRepo.save(monan.get());
        congthucRepo.save(congthuc);
        return congthuc;
    }
    @Override
    public Loaimonan xoaLoaimonan(int loaimonanID) {
        Optional<Loaimonan> xoaLoai = loaimonanRepo.findById(loaimonanID);
        if(xoaLoai.get().getMonans().isEmpty()) {
            loaimonanRepo.deleteById(loaimonanID);
            return xoaLoai.get();
        }
        xoaLoai.get().getMonans().forEach(x->{
            x.getCongthucs().forEach(y->{
                congthucRepo.delete(y);
                nguyenlieuRepo.delete(y.getNguyenlieu());
            });
            monanRepo.delete(x);
        });
        loaimonanRepo.deleteById(loaimonanID);
        return xoaLoai.get();
    }

    @Override
    public Set<Monan> timKiemMonan(String Tenmonan, String Tennguyenlieu) {
        List<Monan> monans = monanRepo.findAll();
        Set<Monan> monanTheoten = new HashSet<>();
        monans.forEach(x->{
            if(x.getTenmon()==(Tenmonan))
                monanTheoten.add(x);
        });
        Set<Monan> monanCantim = new HashSet<>();
        monans.forEach(x->{
            x.getCongthucs().forEach(y->{
                if(y.getNguyenlieu().getTennguyenlieu()==(Tennguyenlieu))
                    monanCantim.add(x);
            });
        });

        return monanCantim;
    }
}
