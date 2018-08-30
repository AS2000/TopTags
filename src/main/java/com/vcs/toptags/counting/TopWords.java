package com.vcs.toptags.counting;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class TopWords {

    @Bean
    public String[] getTopWords(Map<String, Integer> map, int qtyTopWords) {

        return calculateTop(map, qtyTopWords);
    }

    @Bean
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
