package org.example;


import com.aspose.words.Document;
import com.aspose.words.LoadOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static String[] ch = {
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "0","1","2","3","4","5","6","7","8","9",""
    };
    private static int passLength = 8;
    private static int count = 0;
    private static String path = "C:\\Users\\asa\\Desktop";
    private static String fileName = "testFile.docx";
    private static String[] names = {"Karla","karla"};
    private static boolean bruteForceRunning;

    public static void main(String[] args) throws IOException {
        //Brute force lopper method.
        crackLoop();
    }

    private static void crackLoop(){
        bruteForceRunning = true;
        //Separate thread for seeing tested count
        new Thread(() -> {
            try {
                printTestCount();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        IntStream.range(0, ch.length).parallel().forEach(a -> {
            IntStream.range(0,ch.length).parallel().forEach(b -> {
                IntStream.range(0,ch.length).parallel().forEach(c -> {
                    IntStream.range(0,ch.length).parallel().forEach(d -> {
                        IntStream.range(0,ch.length).parallel().forEach(e -> {
                            IntStream.range(0,ch.length).parallel().forEach(f -> {
                                IntStream.range(0,ch.length).parallel().forEach(g -> {
                                    IntStream.range(0,ch.length).parallel().forEach(h -> {
                                        IntStream.range(0,ch.length).parallel().forEach(i -> {
                                            InputStream in;
                                            try {
                                                in = new FileInputStream(path+"\\"+fileName);
                                                try{
                                                    LoadOptions loadOptions = new LoadOptions(ch[a]+ch[b]+ch[c]+ch[d]+ch[e]+ch[f]+ch[g]+ch[h]+ch[i]);
                                                    Document doc = new Document(in,loadOptions);
                                                    System.out.println(doc.getProtectionType());
                                                    System.out.println("Password is: "+ch[a]+ch[b]+ch[c]+ch[d]+ch[e]+ch[f]+ch[g]+ch[h]+ch[i]);
                                                    bruteForceRunning = false;
                                                    Thread.sleep(600000);
                                                    System.exit(0);
                                                }catch (Exception ex){
                                                    //System.out.println("Pass not found, tested pass: "+name+a+b+c+d);
                                                }
                                                in.close();
                                            } catch (FileNotFoundException ex) {
                                                throw new RuntimeException(ex);
                                            } catch (IOException ex) {
                                                throw new RuntimeException(ex);
                                            }
                                            count++;
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
//        for(int a = 0; a < ch.length; a++){
//            for(int b = 0; b < ch.length;b++){
//                for(int c = 0; c < ch.length;c++){
//                    for(int d = 0; d < ch.length;d++){
//                        for(int e = 0; e < ch.length;e++){
//                            for(int f = 0; f < ch.length;f++){
//                                for(int g = 0; g < ch.length;g++){
//                                    for(int h = 0; h < ch.length;h++){
//                                        String tempStr = ""+a+b+c+d+e+f+g+h;
//                                        if(tempStr.equals("Kage1234"))
//                                            System.out.println(tempStr);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        IntStream.range(0,10).parallel().forEach(a -> {
//            IntStream.range(0,10).parallel().forEach(b -> {
//                IntStream.range(0,10).parallel().forEach(c -> {
//                    IntStream.range(0,10).parallel().forEach(d -> {
//                        for(String name : names){
//                            InputStream in = new FileInputStream(path+"\\"+fileName);
//                            try{
//                                LoadOptions loadOptions = new LoadOptions(name+a+b+c+d);
//                                Document doc = new Document(in,loadOptions);
//                                System.out.println(doc.getProtectionType());
//                                System.out.println("Password is: "+name+a+b+c+d);
//                                Thread.sleep(600000);
//                            }catch (Exception e){
//                                System.out.println("Pass not found, tested pass: "+name+a+b+c+d);
//                            }
//                            in.close();
//                        }
//                    });
//                });
//            });
//        });
        bruteForceRunning = false;
    }

    private static void printTestCount() throws InterruptedException {
        while(bruteForceRunning){
            System.out.println("Tested combinations count: " + count + "Current time: " + LocalDateTime.now());
            Thread.sleep(10000);
        }
    }
}