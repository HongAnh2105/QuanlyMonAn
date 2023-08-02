package com.example.jpabaii5.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "congthucs")
public class Congthuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int congthucid;
    @Column(name = "monanid",insertable = false,updatable = false)
    private int monanId;
    @ManyToOne()
    @JoinColumn(name = "monanid")
    @JsonBackReference
    private Monan monan;
    @Column(name = "nguyenlieuid",insertable = false,updatable = false)
    private int nguyenlieuId;
    @ManyToOne()
    @JoinColumn(name = "nguyenlieuid")
    @JsonBackReference
    private Nguyenlieu nguyenlieu;
    private int soluong;
    private int donvitinh;

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(int donvitinh) {
        this.donvitinh = donvitinh;
    }

    public int getCongthucid() {
        return congthucid;
    }

    public void setCongthucid(int congthucid) {
        this.congthucid = congthucid;
    }

    public int getMonanId() {
        return monanId;
    }

    public void setMonanId(int monanId) {
        this.monanId = monanId;
    }

    public Monan getMonan() {
        return monan;
    }

    public void setMonan(Monan monan) {
        this.monan = monan;
    }

    public int getNguyenlieuId() {
        return nguyenlieuId;
    }

    public void setNguyenlieuId(int nguyenlieuId) {
        this.nguyenlieuId = nguyenlieuId;
    }

    public Nguyenlieu getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(Nguyenlieu nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }
}
