package com.vcs.toptags.io;

import com.vcs.toptags.page_adapters.INewsPage;

public class PrintAll {
    public void printTopWords(INewsPage newsPage) {
        System.out.println("\n" + "TOP " + newsPage.getWebDomain() + " WORDS: ");
        System.out.println("Checked words qty.: " + newsPage.getCheckedWordsQty());
        System.out.println("Unique words qty.: " + newsPage.getUniqueWordsQty() + "\n");

        for (int i = 0; i < newsPage.getFilteredTopWordsArray().length; i++) {
            System.out.println((i + 1) + ". " + newsPage.getFilteredTopWordsArray()[i]);
        }
        System.out.println("");
    }
}
