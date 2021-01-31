package day12.task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<MusicBand> bands = new ArrayList<>(Arrays.asList(
                new MusicBand("Linkin Park", 1996),
                new MusicBand("Bring Me The Horizon", 2004),
                new MusicBand("Asking Alexandria", 2008),
                new MusicBand("Rammstein", 1994),
                new MusicBand("Eskimo Callboy", 2010),
                new MusicBand("Falling in Reverse", 2008),
                new MusicBand("Architects", 2004),
                new MusicBand("Papa Roach", 1993),
                new MusicBand("Slipknot", 1995),
                new MusicBand("Limp Bizkit", 1994),
                new MusicBand("Die Antwoord", 2008)));

        Collections.shuffle(bands);
        bands.forEach(band -> System.out.println(band));

        List<MusicBand> newBands = groupsAfter2000(bands);
        System.out.println("Список групп, образованных после 2000 года:");
        newBands.forEach(band -> System.out.println(band));
    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        Iterator<MusicBand> iterator = bands.iterator();
        while (iterator.hasNext()) {
            MusicBand band = iterator.next();
            if (band.getYear() < 2000) {
                iterator.remove();
            }
        }
        return bands;
    }
}
