package com.laoma.mystudy.cg.frist;

public class Movie {
    //儿童片
    public static  final  int CHILDRENS = 2;
    //普通
    public static  final  int REGULAR = 0;
    //新片
    public static final int NEW_RELEASE = 1;

    private String _title;

    private int _priceCode;

    public Movie(String title,int price){
        _title = title;
        _priceCode = price;
    }

    public int getPriceCode(){
        return _priceCode;
    }
    public  void setPriceCode(int arg){
        _priceCode = arg ;
    }

    public String getTitle(){
        return _title;
    }
}

class Rental{
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie ,int daysRented){
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented(){
        return _daysRented;
    }

    public  Movie getMovie(){
        return _movie;
    }

}
