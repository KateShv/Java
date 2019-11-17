package lesson6;

import java.io.*;
import java.nio.file.*;
import java.util.Random;

public class Main {

    //все потоки ввода\вывода открываю в ресурсах try, чтобы при выполнении блока они закрывались
    //все методы работают с любыми текстовыми файлами и папками, если указыавть их полный путь

    private static Random random = new Random();

    //простая запись строк в файл
    private static void recordInFile (String name, String msg) {
        try (FileOutputStream fos = new FileOutputStream(name, true)){
            fos.write(msg.getBytes());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    //запись в файл беря рандомно слова из массива, количество записываемых слов также задается
    //иногда прям даже осмысленные фразы рандомно получаются у компьютера :D
    private static void recordInFileRandom(String name, int fileLength, String[] arr) {
        try (FileOutputStream fos = new FileOutputStream(name, true)){
            for (int i = 0; i <= fileLength; i++) {
                fos.write(arr[random.nextInt(arr.length)].getBytes());
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    //склейка двух файлов при прочтении второго, сразу записывая символы в конец первого
    //при желании как файл1 можно указать пустой файл и вызвать метод 2 раза, передавая
    //как файл2 другие 2 файла в нужной последовательности
    //склеится по сути также
    private static void splice (String fileA, String fileB) {
        try (FileOutputStream fos = new FileOutputStream(fileA, true); FileInputStream fin = new FileInputStream(fileB)){
            int i;
            while ((i = fin.read()) != -1) {
                fos.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //1 вариант: используем класс файл
    // сразу ищет слово при прочтении файла
    private static boolean readLine (String fileName, String word) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName))).contains(word);
    }

    //2 вариант: используем файлинпутстрим и стрингбилдер
    //поиск искомого в файле посимвольно
    private static boolean equalsChar (String fileName, String word) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fin = new FileInputStream(fileName)) {
            int i;
            while ((i = fin.read()) != -1) {
                sb.append((char) i);
                if (sb.toString().contains(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        return false;
    }

    //3 вариант: только с инпутстримом, сравнивая байты
    private static boolean searchWord (String fileName, String word) {
        try (FileInputStream fin = new FileInputStream(fileName)) {
            byte[] bytes = word.getBytes();
            if ((new String(fin.readAllBytes())).contains(new String(bytes))) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //поиск слов !во всех файлах папки!, не входя в подкаталоги
    //использовать для поиска слова в ифе можно:
    // - readLine (для метода добавление throws IOException обязательно тк в readLine нет блока трай кэтч)
    // - equalsChar (с ним для метода указывать throws необязательно, тк в методе equalsChar есть трай кэтч)
    //можно сделать и возвращающим булево, но тогда в результате не понятно в каком файле таки есть слово,
    //будет только известно, что в папке есть файл с таким словом
    private static void searchInFiles (File folder, String word) {
        File[] list = folder.listFiles();
        if (list != null) {
            for (File a : list) {
                if (a.isFile() && equalsChar(a.toString(), word)) {
                    System.out.printf("В файле %s есть: %s\n", a.toString(), word);
                }
            }
        }
    }

    //поиск слов !по всем файлам папки, включая подкаталоги!
    //использовать для поиска слова в ифе можно:
    // - readLine (для метода добавление throws IOException обязательно тк в readLine нет блока трай кэтч)
    // - equalsChar (с ним для метода указывать throws необязательно, тк в методе equalsChar есть трай кэтч)
    //можно сделать и возвращающим булево, но тогда в результате не понятно в каком файле таки есть слово,
    //будет только известно, что в папке есть файл с таким словом
    private static void readFilesInFolder(File folder, String wordSearch) throws IOException {
        File[] list = folder.listFiles();
        if (list != null) {
            for (File a : list) {
                if (a.isDirectory()) {                  //рекурсия для вхождения в подкаталоги
                    readFilesInFolder(a, wordSearch);
                    continue;
                }
                //тут будет пойман файл и его можно обработать
                if (readLine(a.toString(), wordSearch)) {
                    System.out.printf("В файле %s есть: %s\n", a.getName(), wordSearch);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        String[] arr = {"\n", "Harry ", "Dumbledor ", "go ", "wait for ", "scool ", "to ", "the ", "look ", "arround ", "win ", "goblet of fire ", ", ", ". "};
        String fileName1 = "D:\\обучение\\ява1\\6урок\\lesson6\\random1.txt",
                fileName2 = "D:\\обучение\\ява1\\6урок\\lesson6\\random2.txt",
                fileName3 = "D:\\обучение\\ява1\\6урок\\lesson6\\test.txt",
                wordForSearch1 = "scool", wordForSearch2 = "Vernon";
        File directory = new File("D:\\обучение\\ява1\\6урок\\lesson6");

        recordInFileRandom(fileName1, 1000, arr);
        recordInFileRandom(fileName2, 500, arr);

        splice(fileName1, fileName2);

        if (equalsChar(fileName1, wordForSearch1)) {
            System.out.printf("В файле %s есть: %s\n", fileName1, wordForSearch1);
        } else {
            System.out.printf("В файле %s нет: %s\n", fileName1, wordForSearch1);
        }

        if (equalsChar(fileName2, wordForSearch2)) {
            System.out.printf("В файле %s есть: %s\n", fileName2, wordForSearch2);
        } else {
            System.out.printf("В файле %s нет: %s\n", fileName2, wordForSearch2);
        }

        if (searchWord(fileName3, wordForSearch2)) {
            System.out.printf("В файле %s есть: %s\n", fileName3, wordForSearch2);
        } else {
            System.out.printf("В файле %s нет: %s\n", fileName3, wordForSearch2);
        }

        searchInFiles(directory, wordForSearch2);
        searchInFiles(directory, wordForSearch1);

        readFilesInFolder(directory, wordForSearch2);

    }
}
