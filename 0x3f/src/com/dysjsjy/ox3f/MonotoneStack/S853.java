package com.dysjsjy.ox3f.MonotoneStack;

import java.util.*;

public class S853 {

    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            Car[] carList = new Car[n];
            for (int i = 0; i < n; i++) {
                carList[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
            }
            Arrays.sort(carList, (c1, c2) -> Integer.compare(c1.position, c2.position));

//            Arrays.sort(carList, new Comparator<Car>() {
//                @Override
//                public int compare(Car o1, Car o2) {
//                    return o1.position - o2.position;
//                }
//            });

            int ans = 0, t = n;
            while (--t > 0) {
                if (carList[t].time < carList[t - 1].time) {
                    ans++;
                } else {
                    carList[t-1] = carList[t];
                }
            }

            return ans + (t == 0 ? 1 : 0);
        }
    }

    class Car {
        int position;
        double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}
