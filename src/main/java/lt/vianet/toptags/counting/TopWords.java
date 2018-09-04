package lt.vianet.toptags.counting;


import java.util.Collections;
import java.util.Map;

public class TopWords {

    public String[] getTopWords(Map<String, Integer> map, int qtyTopWords) {

        return calculateTop(map, qtyTopWords);
    }

    private String[] calculateTop(Map<String, Integer> map, int qtyTopWords) {
        String[] array = new String[qtyTopWords];

        // searching for the highest number of word Repeats - topRepeats
        int topRepeats = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();

        // number of TOP Words
        int count = 0;
        for (int i = topRepeats; i > 0; i--) {

            for (Map.Entry<String, Integer> entry : map.entrySet()) {

                if (i == entry.getValue()) {

                    array[count] = entry.getKey();

                    // counting TOP words Qty.
                    count++;
                    if (count == qtyTopWords) {
                        break;
                    }
                }
            }
            if (count == qtyTopWords) {
                break;
            }
        }
        return array;
    }
}
