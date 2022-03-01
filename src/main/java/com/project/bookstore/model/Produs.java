package com.project.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Produs {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_prod;
    @Column(name = "titlu", nullable = false, length = 120)
    private String titlu;
    @Column(name = "autor", nullable = false, length = 60)
    private String autor;
    @Column(name ="editura", nullable = false, length = 70)
    private String editura;
    @Column(name ="gen", nullable = false, length = 50)
    private String gen;
    @Column(name ="cantitate", nullable = false, length = 20)
    private int cantitate;
    @Column(name ="pret", nullable = false, length = 20)
    private double pret;
    @Column(name ="imagine", nullable = false, length = 50)
    private String imagine;

    public Produs(Long id_prod, String titlu, String autor, String editura, String gen, int cantitate, double pret, String imagine) {
        this.id_prod = id_prod;
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.gen = gen;
        this.cantitate = cantitate;
        this.pret = pret;
        this.imagine = imagine;
    }

    public Produs(){

    }

    public Long getId_prod() {
        return id_prod;
    }

    public void setId_prod(Long id_prod) {
        this.id_prod = id_prod;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }
}
