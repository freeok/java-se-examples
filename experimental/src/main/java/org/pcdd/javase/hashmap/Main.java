package org.pcdd.javase.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pcdd
 * date 2022/6/29 周三
 */
public class Main {

    public static void main(String[] args) {
        int cap = 50;
        // 容量并不为50，而是64，初始化大小为大于k的2的整数次方，因为2^5=32、2^6=64,32<50<64,所以选64，通过tableSizeFor(int cap)得出
        Map<String, Object> map = new HashMap<>(cap);

        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(cap - 1);
        int n = -1 >>> numberOfLeadingZeros;
        System.out.println(n + 1);
    }

}
