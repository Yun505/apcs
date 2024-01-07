import java.lang.Math; 

public class WeatherForecast {
    public static void main(String[] args) {
    int a =(int) (Math.random() * 6); 
    switch (a){
        case 0:
            System.out.println("It will rain tom.");
            break;
        case 1:
        case 2:
            System.out.println("it will be sunny");
            break;
        case 3:
            System.out.println("It will be partly sunny");
            break;
        default:
            System.out.println("Who knows"); 
            break;
        }
    }
}
