package com.example.jpabaii5.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "monans")
public class Monan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int monanid;
    private String tenmon;
    private int giaban;
    private String gioithieu;
    private String cachlam;
    @Column(name = "loaimonanid",insertable = false,updatable = false)
    private int loaimonanId;
    @ManyToOne()
    @JoinColumn(name = "loaimonanid")
    @JsonBackReference
    private Loaimonan loaimonan;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "monan")
    @JsonManagedReference
    private List<Congthuc> congthucs;

    public int getMonanid() {
        return monanid;
    }

    public void setMonanid(int monanid) {
        this.monanid = monanid;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }

    public String getCachlam() {
        return cachlam;
    }

    public void setCachlam(String cachlam) {
        this.cachlam = cachlam;
    }

    public int getLoaimonanId() {
        return loaimonanId;
    }

    public void setLoaimonanId(int loaimonanId) {
        this.loaimonanId = loaimonanId;
    }

    public Loaimonan getLoaimonan() {
        return loaimonan;
    }

    public void setLoaimonan(Loaimonan loaimonan) {
        this.loaimonan = loaimonan;
    }

    public List<Congthuc> getCongthucs() {
        return congthucs;
    }

    public void setCongthucs(List<Congthuc> congthucs) {
        this.congthucs = congthucs;
    }
}
