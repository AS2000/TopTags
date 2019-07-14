package lt.vianet.toptags.counting;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

public class TopWords {

    private static final Logger LOG = LoggerFactory.getLogger(TopWords.class);

    public String[] getTopWords(Map<String, Integer> map, int qtyTopWords) {
        return calculateTop(map, qtyTopWords);
    }

    private String[] calculateTop(Map<String, Integer> map, int qtyTopWords) {
        String[] array = new String[qtyTopWords];

        // searching for the highest number of word Repeats - topRepeats
        int topRepeats = 0;

        try {
            topRepeats = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
        } catch (NoSuchElementException nee) {
            LOG.error(nee.getMessage(), nee);
        }
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
