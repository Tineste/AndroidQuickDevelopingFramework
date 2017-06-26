package frame.xuchao.orz.frame.base.util;


import java.util.Random;

/**
 * Created by duandazhi on 15/5/4.
 * 随机字符类
 */
public class MyRandom {
    private static Random r = new Random(System.currentTimeMillis());

    /**
     * 产生随机字符 c1,c2的闭区间
     * @param c1
     * @param c2
     * @return char
     */
    public static char getRandom(char c1,char c2){
        char letter = (char)(c1+ Math.random()*(c2 - c1+1));
        return letter;
    }
    /**
     * 产生随数min,max的闭区间
     * @param min
     * @param max
     * @return
     */
    public  static int getRandom(int min,int max){
        return min + (int)(Math.random()*(max-min+1));
    }
    public static  float getRandmom(float min,float max){
        return min + (float)(Math.random()*(max-min));
    }
    public static double getRandom(double min,double max){
        return min + Math.random()*(max-min);
    }
    /**
     * 产生随机 奇偶数
     * @param min
     * @param max
     * @param isOddNumber
     * @return
     */
    public static  int getRandomOddEven(int min,int max,boolean isOddNumber){
        if(isOddNumber){
            while(true){
                int odd = getRandom(min,max);
                if(odd%2==1){
                    return odd;
                }
            }
        }
        else{
            while(true){
                int odd = getRandom(min,max);
                if(odd%2==0){
                    return odd;
                }
            }
        }
    }

    /**
     * 产生0~9 a~z A~Z的随机数
     * @return
     */
    public static  char getRandom(){
        int type = getRandom(1,3);
        if(type==1){return getRandom('0','9');}
        else if(type==2){return getRandom('a','z');}
        else{return getRandom('A','Z');}
    }

    /**
     * 产生指定数组里面的字符 字符串
     * @param c
     * @return
     */
    public static  char getRandom(char[] c){
        return c[getRandom(0,c.length-1)];
    }
    public static  int getRandom(int[] a){
        return a[getRandom(0,a.length-1)];
    }
    public static String getRandom(String[] str){
        return str[getRandom(0,str.length-1)];
    }

    /**
     * 获得高斯分布的随机数
     * @return
     */
    public static double getGaussian(){
        return r.nextGaussian();
    }
    /**
     * 获得boolean类型随机数
     * @return
     */
    public static boolean getBoolean(){
        return r.nextBoolean();
    }

    /**
     * 获取10位的随机字符串
     *  前5+9527+后5+4
     * @return
     */
    public static String getNumRandomTen() {
        StringBuffer buf = new StringBuffer(10);

        for (int i = 0; i < 5; ++i) {
            buf.append(getRandom('0','9'));
        }
        buf.append("9527");
        for (int i = 0; i < 5; ++i) {
            buf.append(getRandom('0','9'));
        }
        buf.append("4");
        return buf.toString();
    }
}
