package ErrorExeptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

//        Звичайні main програми не продовжують своє виконанна після unchecked exception => RuntimeException => ArrayIndexOutOfBoundsException
//        int[] ints = new int[4];
//        ints[3] = 1; //ok
//        System.out.println("before unchecked exсeption");// ok
//        ints[6] = 4;// error
//        System.out.println("after unchecked exсeption");// not ok
        // компіляція з такою помилкою пройде але виконання ні
//        зазвичай такі помилки не хендляться а перевіряються н-д блок if



        // обробляють їх так же само як unchecked try-catch-ом

//        int[] ints = new int[4];
//        ints[3] = 1;
//        try {
//            ints[6] = 4;
//            System.out.println("after wrong action"); // not logged
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e); //logged
//            e.printStackTrace(); // виведе як помилку але не зупинить виконання main
//        }
//        System.out.println("after try/catch block"); //logged

//                                    try
        //  в try огортати лише той код який може вальнути помилку!!!!!!!!!!!!!!!!!

//                                    catch
        //  в кетч писати варто конкретну помилку а в самому блоці завжди варто проінформувати про помилку (записати в лог)
        //  якщо ми не знаємо яка конкретно вальне помилка - пишемо клас вище по ієрархії

        //  можна викорисовувати декілька catch-ів але це погана практика сувати в трай коди які можуть кидати різні ексепшени
        //  ліпше мати декілька try/catch блоків

        //  якщо є декілька послідовних кетчів то класи помилок повинні бути в ієрархії від
        //  найбільш конкретного до більш загального
        //
        // якщо є декілька класів помилок в одному кечі через "|"
        // це повинні бути класи нащадки які нічого один про одного не знають

//        int[] arr = new int[4];
//        try {
//            Connection connection = DriverManager.getConnection("afaf", "w44", "agadg");
//            arr[5] = 3;
//        } catch (NoSuchElementException | NullPointerException | ArrayIndexOutOfBoundsException | SQLException e) {
//                System.out.println(e);
//        }
        // тут ми не можемо написати клас Exeption так як він загальний для перших трьох
        //
        // максимально чистий код - трай з одним кетчом


//                          finally block
//        виконується завжди є помилка чи немає навіть якщо блоку catch нема
//        Він може бути замість кетчу але ексепшен він не обробить хоча і виконається навіть якщо помилка впаде



        // ми не не можемо ловити checked exception якщо немає коду який може його вальнути
        // checked exeptions ми повинні хендлити - без цього не можлива компіляція




        //                          кастомні ексепшени
//        String s  = "fight club";
//        if (s.equals("fight club")) {
//            throw new CustomEX("do not tell anybody about fight club");
//
//        }

        //зазвичай при створенні свого ексепшена ми наслідуємося або від RuntimeExeption(unchecked) or Exeption (checked)




        // хендлимо помилку на місці
//        try {
//            checkString();
//        } catch (CustomEX customEX) {
//            customEX.printStackTrace();
//        }
//    }

//    private static void checkString() throws CustomEX {
//        в данному випадку нам не потрібно хендлити можливу unckecked помилку ми це зробими на місці виконання
//        String s  = "fight club";
//        if (s.equals("fight club")) {
//            throw new CustomEX("do not tell anybody about fight club");
//
//        }
    }
}
// throw - кидає помилки
// thorws - прокидує помилку на зовні (вище) з методу
