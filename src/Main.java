import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String key = ".";

    static String str;
    static String copy;

    static int i = 0;
    static int k = 3; // 줄 바꿈 설정

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while ((str = in.readLine()) != null) {
            if(str.equals(key)) // 설정 키 입력 시 while 문 빠져나옴
                break;

            if(str.length() <= 1) // 공백 제거 후 줄 바꿈
                continue;


            if(i % k == 0) // k 번째 줄 부터 공백 추가
                copy += "\n";

            copy += str + "\n";
            i++;
        }

        in.close(); // 버퍼 닫기

        copy = copy.replace("null", ""); // 첫줄 공백 제거

        copy = copy.replace("\n", System.getProperty("line.separator")); // 운영체제에 맞게 줄 바꿈 처리

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(copy), null); // 줄 바꿈 처리한 텍스트 복사

        System.out.println("복사 완료");
    }
}




