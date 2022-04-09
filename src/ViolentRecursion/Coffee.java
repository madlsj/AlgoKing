package ViolentRecursion;


public class Coffee {
    //drinks 所有杯子可以开始洗的时间
    //wash 单个杯子洗干净的时间
    //air 挥发干净的时间
    //free 洗的机器什么时候可以用
    //index...都变干净返回的最早时间
    public static int bestTime(int[] drinks, int wash, int air, int index, int free){
        if (index == drinks.length){
            return 0;
        }
        //以下都是基于index号杯子做抉择
        // index号杯子 决定洗
        int selfClean1 = Math.max(drinks[index], free) + wash; //当前杯子可以洗的时间 和 咖啡机空闲时间谁晚  已经做出选择洗了
        int restClean1 = bestTime(drinks, wash, air, index + 1, selfClean1);//做出选择洗了，空闲时间就变了
        int p1 = Math.max(selfClean1, restClean1); //后面可能选择挥发 比当前洗完还早。 那么当前杯子选择洗的时间 当然是最晚的
        // index号杯子 决定挥发
        int selfClean2 = drinks[index] + wash;
        int restClean2 = bestTime(drinks, wash, air, index, free);
        int p2 = Math.max(selfClean2, restClean2);
        return Math.min(p1, p2);
        
    }
}
