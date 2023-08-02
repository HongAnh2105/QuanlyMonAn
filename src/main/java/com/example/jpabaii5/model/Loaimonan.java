    package com.example.jpabaii5.model;

    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import jakarta.persistence.*;

    import java.util.List;

    @Entity
    @Table(name = "loanmonans")
    public class Loaimonan {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int loaimonanid;
        private String tenloai;
        private String mota;
        @OneToMany(fetch = FetchType.LAZY,mappedBy = "loaimonan")
        @JsonManagedReference
        private List<Monan> monans;

        public int getLoaimonanid() {
            return loaimonanid;
        }

        public void setLoaimonanid(int loaimonanid) {
            this.loaimonanid = loaimonanid;
        }

        public String getTenloai() {
            return tenloai;
        }

        public void setTenloai(String tenloai) {
            this.tenloai = tenloai;
        }

        public String getMota() {
            return mota;
        }

        public void setMota(String mota) {
            this.mota = mota;
        }

        public List<Monan> getMonans() {
            return monans;
        }

        public void setMonans(List<Monan> monans) {
            this.monans = monans;
        }
    }
