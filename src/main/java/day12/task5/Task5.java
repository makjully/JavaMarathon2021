package day12.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<MusicArtist> members1 = new ArrayList<>(Arrays.asList(
                new MusicArtist("Billie Joe Armstrong", 48),
                new MusicArtist("Mike Dirnt", 48),
                new MusicArtist("Tré Cool", 48)));
        MusicBand greenDay = new MusicBand("Green day", 1987, members1);

        List<MusicArtist> members2 = new ArrayList<>(Arrays.asList(
                new MusicArtist("Jens Kidman", 54),
                new MusicArtist("Fredrik Thordendal", 50),
                new MusicArtist("Tomas Haake", 49),
                new MusicArtist("Mårten Hagström", 49),
                new MusicArtist("Dick Lövgren", 40)));
        MusicBand meshuggah = new MusicBand("Meshuggah", 1987, members2);

        MusicBand.transferMembers(meshuggah, greenDay);

        System.out.println("Состав группы Green day:");
        greenDay.printMembers(greenDay.getMembers());
        System.out.println("Состав группы Meshuggah:");
        meshuggah.printMembers(meshuggah.getMembers());
    }
}
