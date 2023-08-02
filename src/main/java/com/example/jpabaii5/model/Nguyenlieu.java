package com.example.jpabaii5.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "nguyenlieus")
public class Nguyenlieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nguyenlieuid;
    private String tennguyenlieu;
    private String ghichu;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "nguyenlieu")
    @JsonManagedReference
    private List<Congthuc> congthucs;

    public int getNguyenlieuid() {
        return nguyenlieuid;
    }

    public void setNguyenlieuid(int nguyenlieuid) {
        this.nguyenlieuid = nguyenlieuid;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public List<Congthuc> getCongthucs() {
        return congthucs;
    }

    public void setCongthucs(List<Congthuc> congthucs) {
        this.congthucs = congthucs;
    }
}
