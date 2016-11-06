package com.hfad.kursach;


public class Acid {
    String name;
    double Ka1;
    double Ka2;
    double Ka3;

    //acids - массив с элементами acid. Здесь нужно будет создать объекты в виде: (кислота,Ka1)
      public static final Acid [] acids = {
            new Acid("Фосфорная кислота", 0.0071, 0.000000062, 0.0000000000005),
            new Acid("Сероводородная кислота", 0.0000001, 0.00000000000025),
            new Acid("Иодноватистая кислота", 0.000000000023)
};





    private Acid(String name, double Ka1) {
        this.name = name;
        this.Ka1 = Ka1;
    }

    private Acid(String name, double Ka1, double Ka2) {
        this.name = name;
        this.Ka1 = Ka1;
        this.Ka2 = Ka2;
    }
    private Acid(String name, double Ka1, double Ka2, double Ka3) {
        this.name = name;
        this.Ka1 = Ka1;
        this.Ka2 = Ka2;
        this.Ka3 = Ka3;
    }

    public String getName() {
        return this.name;
    }
    public double getKa1() {
        return this.Ka1;
    }
    public double getKa2() {
        return this.Ka2;
    }
    public double getKa3() {
        return this.Ka3;
    }
    public String toString() {
        return this.name;
    }
    public void setName(String name1) {
        name1 = name;
    }
}


