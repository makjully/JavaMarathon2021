package day12.task4;

import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        MusicBand bmth = new MusicBand("Bring Me The Horizon", 2004,
                new ArrayList<>(Arrays.asList("Oliver Sykes", "Matt Kean", "Lee Malia", "Matt Nicholls", "Jordan Fish")));

        MusicBand babymetal = new MusicBand("Babymetal", 2010,
                new ArrayList<>(Arrays.asList("Suzuka Nakamoto", "Moa Kikuchi")));

        MusicBand.transferMembers(babymetal, bmth);

        System.out.println("Состав группы Bring Me The Horizon:");
        bmth.printMembers(bmth.getMembers());
        System.out.println("Состав группы Babymetal:");
        babymetal.printMembers(babymetal.getMembers());
    }
}
