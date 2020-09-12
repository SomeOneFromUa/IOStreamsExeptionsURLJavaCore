package IOstreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    File file = new File("1.txt");
    // взнати метаданні чи видалити ми можемо але редагувати ні

//        IO (input output) streams - байтові або символьні потоки
//        символьний потік не можна використовувати для чогось у пікселях (картинки н-д)
//        але для запису чогось у файл текстовий - можна використовувати і той і той

//        byte	    1 byte	       Stores whole numbers from -128 to 127
//        short	    2 bytes	       Stores whole numbers from -32,768 to 32,767
//        int	    4 bytes	       Stores whole numbers from -2,147,483,648 to 2,147,483,647
//        long	    8 bytes	       Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
//        float	    4 bytes	       Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
//        double	8 bytes	       Stores fractional numbers. Sufficient for storing 15 decimal digits
//        boolean	1 bit	       Stores true or false values
//        char	    2 bytes	       Stores a single character/letter or ASCII values

//                            Аутпут стрім = програма - джерело
        // try with resources - фішка жаби 7 - стрім буде закритий автоматично без відповідного коду в finally
        try(FileOutputStream fileOutputStream = new FileOutputStream(file, false)) {// append: true файл дозаписується а false(по замовчуванню) - ні
            fileOutputStream.write("hello".getBytes()); // так як це байтовий стрім - то ми маємо передавати байтове представлення
//String має метод getBytes
        } catch (IOException e) {
            e.printStackTrace();
        }
//                            ІнпутСтрім
//        try(FileInputStream fileInputStream = new FileInputStream(file);) {
////            System.out.println(fileInputStream.read()); // виведе аскі код першої букви 104
////            System.out.println(Integer.toBinaryString(fileInputStream.read())); // виведе байтове представлення другої букви 1100101
////            System.out.println((char) fileInputStream.read()); // явна типізація виведе просто третю букву l
////            // посимвольно - тому що побайтово - прочитало один байт і забило
//            int i;
//            while ((i = fileInputStream.read()) != -1){
//                System.out.println((char)i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        символьні потоки
//        FileWriter and FileReader - роблять все так само як у прикладах вище але відразу по символам
//        BufferedWriter - працює із символьними стрімами


        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
           bufferedWriter.write("hello world \nhello universe"); ;
        } catch (IOException e) {
            e.printStackTrace();
        }


        try( BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
           String s;
           while ((s = bufferedReader.readLine()) != null){
               System.out.println(s);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        будь-який output stream до неіснуючого файлу - створить його а input stream вальне ексепшн
    }
}
