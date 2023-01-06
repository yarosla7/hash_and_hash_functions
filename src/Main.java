public class Main {
    public static void main(String[] args) {
        Car lada = new Car("Lada", "Granta", 1.7," ", 2015, " ");
        System.out.println("lada.toString() = " + lada);
        Car audi = new Car("Audi", "A8 50L TDI quattro", 3.0, "black", 2020, "Germany");
        System.out.println("audi.toString() = " + audi);
        Car bmw = new Car("BMW", "Z8", 3.0, "black", 2021, "Germany");
        System.out.println("bmw.toString() = " + bmw);
        Car kia = new Car("Kia", "Sportage 4th generation", 2.4, "red", 2018, "South Korea");
        System.out.println("kia.toString() = " + kia);
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "orange", 2016, "South Korea");
        System.out.println("hyundai.toString() = " + hyundai);
        Car myCar = new Car("","",0,"",-100,"");
        System.out.println("emptyCar.toString() = " + myCar);
    }
}