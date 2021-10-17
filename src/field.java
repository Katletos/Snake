import java.util.Scanner;
public class field {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите размер поля");
        System.out.println("1:Большое; 2:Среднее; 3:Маленькое");
        int raz = in.nextInt();

        System.out.println("Выберите количество препятствий");
        System.out.println("1:Нет; 2:Мало; 3:Средне; 4:Много");
        int colich = in.nextInt();

        if (raz==1)
        {
            int razmer=1000;
            switch (colich) {
                case 1:
                    colich = 0;
                    break;
                case 2:
                    colich =50;
                    break;
                case 3:
                    colich =100;
                    break;
                case 4:
                    colich =250;
                    break;
            }

        }

        if (raz==2)
        {
            int razmer=500;
            switch (colich) {
                case 1:
                    colich = 0;
                    break;
                case 2:
                    colich =25;
                    break;
                case 3:
                    colich =50;
                    break;
                case 4:
                    colich =100;
                    break;
            }

        }

        if (raz==3)
        {
            int razmer=250;
            switch (colich) {
                case 1:
                    colich = 0;
                    break;
                case 2:
                    colich =10;
                    break;
                case 3:
                    colich =30;
                    break;
                case 4:
                    colich =50;
                    break;
            }

        }
        int[][] pol = new int[1000][1000];
       for (int i = 1; i < 110; i++){
           for (int j=1;j < 110;j++) {

           }
       }
    }
    }
