public class Main {
    public static void main(String[] args) {
        Car lada = new Car();
        lada.brand = "Lada";
        lada.model = "Granta";
        lada.year = 2015;
        lada.country = "Russia";
        lada.color = "жёлтый";
        lada.engineVolume = 1.7;
        System.out.println("lada.toString() = " + lada.toString());
        Car audi = new Car();
        audi.brand = "Audi";
        audi.model = "A8 50L TDI quattro";
        audi.year = 2020;
        audi.country = "Germany";
        audi.color = "черный";
        audi.engineVolume = 3.0;
        System.out.println("audi.toString() = " + audi.toString());
        Car bmw = new Car();
        bmw.brand = "BMW";
        bmw.model = "Z8";
        bmw.year = 2021;
        bmw.country = "Germany";
        bmw.color = "черный";
        bmw.engineVolume = 3.0;
        System.out.println("bmw.toString() = " + bmw.toString());
        Car kia = new Car();
        kia.brand = "Kia";
        kia.model = "Sportage 4th generation";
        kia.year = 2018;
        kia.country = "South Korea";
        kia.color = "красный";
        kia.engineVolume = 2.4;
        System.out.println("kia.toString() = " + kia.toString());
        Car hyundai = new Car();
        hyundai.brand = "Hyundai";
        hyundai.model = "Avante";
        hyundai.year = 2016;
        hyundai.country = "South Korea";
        hyundai.color = "оранжевый";
        hyundai.engineVolume = 1.6;
        System.out.println("hyundai.toString() = " + hyundai.toString());
    }
}