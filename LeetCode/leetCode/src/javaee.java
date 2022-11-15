public class javaee {
    public static void main(String[] args) {
        String[][] strings = new String[30][60];
        int num=0;
        String str="PHQGHUMEAYLNLFDXFIRCVSCXGGBWKFNQDUXWFNFOZVSRTKJPREPGGXRPNRVY" +
                "STMWCYSYYCQPEVIKEFFMZNIMKKASVWSRENZKYCXFXTLSGYPSFADPOOEFXZBC" +
                "OEJUVPVABOYGPOEYLFPBNPLJVRVIPYAMYEHWQNQRQPMXUJJLOOVAOWUXWHMS" +
                "NCBXCOKSFZKVATXDKNLYJYHFIXJSWNKKUFNUXXZRZBMNMGQOOKETLYHNKOAU" +
                "GZQRCDDIUTEIOJWAYYZPVSCMPSAJLFVGUBFAAOVLZYLNTRKDCPWSRTESJWHD" +
                "IZCOBZCNFWLQIJTVDWVXHRCBLDVGYLWGBUSBMBORXTLHCSMPXOHGMGNKEUFD" +
                "XOTOGBGXPEYANFETCUKEPZSHKLJUGGGEKJDQZJENPEVQGXIEPJSRDZJAZUJL" +
                "LCHHBFQMKIMWZOBIWYBXDUUNFSKSRSRTEKMQDCYZJEEUHMSRQCOZIJIPFION" +
                "EEDDPSZRNAVYMMTATBDZQSOEMUVNPPPSUACBAZUXMHECTHLEGRPUNKDMBPPW" +
                "EQTGJOPARMOWZDQYOXYTJBBHAWDYDCPRJBXPHOOHPKWQYUHRQZHNBNFUVQNQ" +
                "QLRZJPXIOGVLIEXDZUZOSRKRUSVOJBRZMWZPOWKJILEFRAAMDIGPNPUUHGXP" +
                "QNJWJMWAXXMNSNHHLQQRZUDLTFZOTCJTNZXUGLSDSMZCNOCKVFAJFRMXOTHO" +
                "WKBJZWUCWLJFRIMPMYHCHZRIWKBARXBGFCBCEYHJUGIXWTBVTREHBBCPXIFB" +
                "XVFBCGKCFQCKCOTZGKUBMJRMBSZTSSHFROEFWSJRXJHGUZYUPZWWEIQURPIX" +
                "IQFLDUUVEOOWQCUDHNEFNJHAIMUCZFSKUIDUBURISWTBRECUYKABFCVKDZEZ" +
                "TOIDUKUHJZEFCZZZBFKQDPQZIKFOBUCDHTHXDJGKJELRLPAXAMCEROSWITDP" +
                "TPCCLIFKELJYTIHRCQAYBNEFXNXVGZEDYYHNGYCDRUDMPHMECKOTRWOSPOFG" +
                "HFOZQVLQFXWWKMFXDYYGMDCASZSGOVSODKJGHCWMBMXRMHUYFYQGAJQKCKLZ" +
                "NAYXQKQOYZWMYUBZAZCPKHKTKYDZIVCUYPURFMBISGEKYRGZVXDHPOAMVAFY" +
                "RARXSVKHTQDIHERSIGBHZJZUJXMMYSPNARAEWKEGJCCVHHRJVBJTSQDJOOTG" +
                "PKNFPFYCGFIEOWQRWWWPZSQMETOGEPSPXNVJIUPALYYNMKMNUVKLHSECDWRA" +
                "CGFMZKGIPDFODKJMJQWIQPUOQHIMVFVUZWYVIJGFULLKJDUHSJAFBTLKMFQR" +
                "MYJFJNHHSSQCTYDTEAMDCJBPRHTNEGYIWXGCJWLGRSMEAEARWTVJSJBAOIOJ" +
                "LWHYPNVRUIHOSWKIFYGTYDHACWYHSGEWZMTGONZLTJHGAUHNIHREQGJFWKJS" +
                "MTPJHAEFQZAAULDRCHJCCDYRFVVRIVUYEEGFIVDRCYGURQDREDAKUBNFGUPR" +
                "OQYLOBCWQXKZMAUSJGMHCMHGDNMPHNQKAMHURKTRFFACLVGRZKKLDACLLTEO" +
                "JOMONXRQYJZGINRNNZWACXXAEDRWUDXZRFUSEWJTBOXVYNFHKSTCENAUMNDD" +
                "XFDMVZCAUTDCCKXAAYDZSXTTOBBGQNGVVPJGOJOGLMKXGBFCPYPCKQCHBDDZ" +
                "WRXBZMQRLXVOBTWHXGINFGFRCCLMZNMJUGWWBSQFCIHUBSJOLLMSQSGHMCPH" +
                "ELSOTFLBGSFNPCUZSRUPCHYNVZHCPQUGRIWNIQXDFJPWPXFBLKPNPEELFJMT";

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 60; j++) {
                strings[i][j]=str.charAt(num)+"";
                num++;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();

        int sum=0;
        for (int i = 1; i < 29; i++) {
            for (int j = 1; j < 29; j++) {
                if(strings[i][j].charAt(0)<strings[i-1][j].charAt(0)&&strings[i][j].charAt(0)<strings[i+1][j].charAt(0)&&strings[i][j].charAt(0)<strings[i][j-1].charAt(0)&&strings[i][j].charAt(0)<strings[i-1][j+1].charAt(0)){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    //位运算符
    public static void test01(){
        int i = 21;
        i = -21;
        System.out.println("i << 2 :" + (i << 2));
        System.out.println("i << 3 :" + (i << 3));
        System.out.println("i << 27 :" + (i << 27));

        int m = 12;
        int n = 5;
        System.out.println("m & n :" + (m & n));
        System.out.println("m | n :" + (m | n));
        System.out.println("m ^ n :" + (m ^ n));
    }

    //可变形参:可以传入0-n个参数，相当于一个该类型的数组
    public static void test02(String s){
        System.out.println("test02");
    }
    public static void test02(String ...  s){
        System.out.println("test03");
    }
    public static void test04(int ... s){
        System.out.println("test04");
    }




}
