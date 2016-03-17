package breizhcamp2016;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        System.out.println((byte) 0xE2);
//        System.out.println((byte) 0x80);
//        System.out.println((byte) 0x8D);

//        byte[] b = { -30, -128, -116 };
//        System.out.println(new String(b, "UTF-8"));
//
//        byte[] b2 = { -21, -84, -72, -21, -78, -107, -20, -99, -128, 32, -21, -117, -92, -21, -91, -72, 32, -20, -106, -72, -20, -106, -76, -20, -105, -112, 32, -20, -104, -127, -19, -106, -91, -20, -99, -124, 32, -21, -80, -101 };
//        System.out.println(new String(b2, "UTF-8"));
                                                    //  "문법은 다른 언어에 영향을 받
        String infile = "문법‍은 다른 언어‍에 영향‍을 받‌았‍다. 문장 뒤‍에‍는 lah‍, leh‍, mah‍를 붙이‌고‍, 동사 시제‍는 변하‌지 않‍는다. be‍동사‍는 생략‌한‍다.";
        String indb =   "문법은 다른 언어에 영향을 받았다. 문장 뒤에는 lah, leh, mah를 붙이고, 동사 시제는 변하지 않는다. be동사는 생략한다.";

//        String infile = "받‌았‍다.";
//        String indb =   "받았다.";
//
//        System.out.println("---");
//        for (int i = 0; i < infile.length(); i++) {
//            System.out.println("code point " + infile.charAt(i) + " = " + infile.codePointAt(i));
//        }
//        System.out.println("---");
//        for (int i = 0; i < indb.length(); i++) {
//            System.out.println("code point " + indb.charAt(i) + " = " + indb.codePointAt(i));
//        }
//        System.out.println("---");

//        String infile = new String("문법‍은 다른 언어‍에 영향‍을 받‌았‍다. 문장 뒤‍에‍는 lah‍, leh‍, mah‍를 붙이‌고‍, 동사 시제‍는 변하‌지 않‍는다. be‍동사‍는 생략‌한‍다.".getBytes(),  Charset.forName("UTF-16"));
//        String indb = new String("문법은 다른 언어에 영향을 받았다. 문장 뒤에는 lah, leh, mah를 붙이고, 동사 시제는 변하지 않는다. be동사는 생략한다.".getBytes(),  Charset.forName("UTF-16"));

        String infile_wo_200cd = infile.replace("\u200D", "").replace("\u200C", "");

        System.out.println("length=" + infile.length() + " vs " + indb.length());
        System.out.println("length=" + infile_wo_200cd.length() + " vs " + indb.length());


        System.out.println("equals=" + infile.equals(indb));
        System.out.println("equals w/o 200C/200D=" + infile_wo_200cd.equals(indb));
        System.out.println("deep equals w/o 200C/200D=" + Objects.deepEquals(infile_wo_200cd.getBytes("UTF-8"), indb.getBytes("UTF-8")));

        System.out.println(Arrays.toString(infile.getBytes("UTF-8")));
        System.out.println(Arrays.toString(infile_wo_200cd.getBytes("UTF-8")));
        System.out.println(Arrays.toString(indb.getBytes("UTF-8")));
    }
}

//[-2, -1, -69, 56, -68, -107, -57, 64, 0, 32, -78, -28, -71, 120, 0, 32, -59, -72, -59, -76, -59, -48, 0, 32, -58, 1, -43, -91, -57, 68, 0, 32, -68, 27, 32, 12, -59, 88, -78, -28, 0, 46, 0, 32, -69, 56, -57, -91, 0, 32, -76, -92, -59, -48, -78, -108, 0, 32, 0, 108, 0, 97, 0, 104, 0, 44, 0, 32, 0, 108, 0, 101, 0, 104, 0, 44, 0, 32, 0, 109, 0, 97, 0, 104, -71, 124, 0, 32, -67, -103, -57, 116, 32, 12, -84, -32, 0, 44, 0, 32, -77, -39, -64, -84, 0, 32, -62, -36, -56, 28, -78, -108, 0, 32, -68, -64, -43, 88, 32, 12, -55, -64, 0, 32, -59, 74, -78, -108, -78, -28, 0, 46, 0, 32, 0, 98, 0, 101, -77, -39, -64, -84, -78, -108, 0, 32, -64, -35, -73, -75, 32, 12, -43, 92, -78, -28, 0, 46]
// "            문법‍은                                                                                              다                     른                                      언                    어‍에                                                   영                  향‍                   을                                 받‌았‍다. 문장 뒤‍에‍는 lah‍, leh‍, mah‍를 붙이‌고‍, 동사 시제‍는 변하‌지 않‍는다. be‍동사‍는 생략‌한‍다."
//[-2, -1, -69, 56, -68, -107, -57, 64, 0, 32, -78, -28, -71, 120, 0, 32, -59, -72, -59, -76, -59, -48, 0, 32, -58, 1, -43, -91, -57, 68, 0, 32, -68, 27, -59, 88, -78, -28, 0, 46, 0, 32, -69, 56, -57, -91, 0, 32, -76, -92, -59, -48, -78, -108, 0, 32, 0, 108, 0, 97, 0, 104, 0, 44, 0, 32, 0, 108, 0, 101, 0, 104, 0, 44, 0, 32, 0, 109, 0, 97, 0, 104, -71, 124, 0, 32, -67, -103, -57, 116, -84, -32, 0, 44, 0, 32, -77, -39, -64, -84, 0, 32, -62, -36, -56, 28, -78, -108, 0, 32, -68, -64, -43, 88, -55, -64, 0, 32, -59, 74, -78, -108, -78, -28, 0, 46, 0, 32, 0, 98, 0, 101, -77, -39, -64, -84, -78, -108, 0, 32, -64, -35, -73, -75, -43, 92, -78, -28, 0, 46]
//"            문                 법                     은                                                        다                     른                                     언                     어                   에                                영                  향                   을                                  받 았다. 문장 뒤에는 lah, leh, mah를 붙이고, 동사 시제는 변하지 않는다. be동사는 생략한다.";

// -30, -128, -115 =
/*
[-21, -84, -72, -21, -78, -107, -30, -128, -115, -20, -99, -128, 32, -21, -117, -92, -21, -91, -72, 32, -20, -106, -72, -20, -106, -76, -30, -128, -115, -20, -105, -112, 32, -20, -104, -127, -19, -106, -91, -30, -128, -115, -20, -99, -124, 32, -21, -80, -101, -30, -128, -116, -20, -107, -104, -30, -128, -115, -21, -117, -92, 46, 32, -21, -84, -72, -20, -98, -91, 32, -21, -110, -92, -30, -128, -115, -20, -105, -112, -30, -128, -115, -21, -118, -108, 32, 108, 97, 104, -30, -128, -115, 44, 32, 108, 101, 104, -30, -128, -115, 44, 32, 109, 97, 104, -30, -128, -115, -21, -91, -68, 32, -21, -74, -103, -20, -99, -76, -30, -128, -116, -22, -77, -96, -30, -128, -115, 44, 32, -21, -113, -103, -20, -126, -84, 32, -20, -117, -100, -20, -96, -100, -30, -128, -115, -21, -118, -108, 32, -21, -77, -128, -19, -107, -104, -30, -128, -116, -20, -89, -128, 32, -20, -107, -118, -30, -128, -115, -21, -118, -108, -21, -117, -92, 46, 32, 98, 101, -30, -128, -115, -21, -113, -103, -20, -126, -84, -30, -128, -115, -21, -118, -108, 32, -20, -125, -99, -21, -98, -75, -30, -128, -116, -19, -107, -100, -30, -128, -115, -21, -117, -92, 46]

[-21, -84, -72, -21, -78, -107, -20, -99, -128, 32, -21, -117, -92, -21, -91, -72, 32, -20, -106, -72, -20, -106, -76, -20, -105, -112, 32, -20, -104, -127, -19, -106, -91, -20, -99, -124, 32, -21, -80, -101, -30, -128, -116, -20, -107, -104, -21, -117, -92, 46, 32, -21, -84, -72, -20, -98, -91, 32, -21, -110, -92, -20, -105, -112, -21, -118, -108, 32, 108, 97, 104, 44, 32, 108, 101, 104, 44, 32, 109, 97, 104, -21, -91, -68, 32, -21, -74, -103, -20, -99, -76, -30, -128, -116, -22, -77, -96, 44, 32, -21, -113, -103, -20, -126, -84, 32, -20, -117, -100, -20, -96, -100, -21, -118, -108, 32, -21, -77, -128, -19, -107, -104, -30, -128, -116, -20, -89, -128, 32, -20, -107, -118, -21, -118, -108, -21, -117, -92, 46, 32, 98, 101, -21, -113, -103, -20, -126, -84, -21, -118, -108, 32, -20, -125, -99, -21, -98, -75, -30, -128, -116, -19, -107, -100, -21, -117, -92, 46]
[-21, -84, -72, -21, -78, -107, -20, -99, -128, 32, -21, -117, -92, -21, -91, -72, 32, -20, -106, -72, -20, -106, -76, -20, -105, -112, 32, -20, -104, -127, -19, -106, -91, -20, -99, -124, 32, -21, -80, -101, -20, -107, -104, -21, -117, -92, 46, 32, -21, -84, -72, -20, -98, -91, 32, -21, -110, -92, -20, -105, -112, -21, -118, -108, 32, 108, 97, 104, 44, 32, 108, 101, 104, 44, 32, 109, 97, 104, -21, -91, -68, 32, -21, -74, -103, -20, -99, -76, -22, -77, -96, 44, 32, -21, -113, -103, -20, -126, -84, 32, -20, -117, -100, -20, -96, -100, -21, -118, -108, 32, -21, -77, -128, -19, -107, -104, -20, -89, -128, 32, -20, -107, -118, -21, -118, -108, -21, -117, -92, 46, 32, 98, 101, -21, -113, -103, -20, -126, -84, -21, -118, -108, 32, -20, -125, -99, -21, -98, -75,                                                                     -19, -107, -100, -21, -117, -92, 46]
*/