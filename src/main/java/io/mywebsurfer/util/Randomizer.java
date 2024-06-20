package io.mywebsurfer.util;

import java.util.Random;

public class Randomizer {


  public static int getRandom(int maxValue) {
    return new Random().nextInt(maxValue);
  }


}
