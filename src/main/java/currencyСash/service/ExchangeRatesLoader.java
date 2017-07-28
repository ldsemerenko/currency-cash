package currencyСash.service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRatesLoader {

    public BufferedInputStream loadXWLAsStream(){
        String urlStr = "http://resources.finance.ua/ua/public/currency-cash.xml";
        System.out.println("loaded as XML");
        return loadAsStream(urlStr);

    }
    public BufferedInputStream loadJSONAsStream(){
        String urlStr = "http://resources.finance.ua/ua/public/currency-cash.json";
        System.out.println("loaded as JSON");
        return loadAsStream(urlStr);

    }

    private BufferedInputStream loadAsStream(String urlStr){
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bis;
    }

    public void saveToFile(BufferedInputStream bufferedInputStream){
        File file = new File("out.xml");    //обрабатывать без записи в файл, через Stream
        FileOutputStream fis = null;
        try {
            fis = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[1024];
        int count = 0;
        try {
            while((count = bufferedInputStream.read(buffer,0,1024)) != -1)
            {
                try {
                    fis.write(buffer, 0, count);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("saved");
    }

    public String getXMLAsStrig(){
        BufferedInputStream bufferedInputStream = loadXWLAsStream();
        StringBuilder stringBuilder = null;
        Scanner scanner = new Scanner(bufferedInputStream);
        while (scanner.hasNext()){
            if(scanner.nextLine() != null) {
                stringBuilder.append(scanner.nextLine());
            }
//            System.out.println(scanner.nextLine());
        }
        return stringBuilder.toString();
    }

    public String getJSONAsStrig(){
        BufferedInputStream bufferedInputStream = loadJSONAsStream();
        StringBuilder string = null;
        Scanner scanner = new Scanner(bufferedInputStream);
//        while (scanner.hasNext()){
//            string.append(scanner.nextLine());
            System.out.println(scanner.nextLine());

//        }
        return scanner.nextLine();
    }
}