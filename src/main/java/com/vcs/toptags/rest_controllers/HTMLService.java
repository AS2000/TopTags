package com.vcs.toptags.rest_controllers;

import com.vcs.toptags.io.CheckTime;
import com.vcs.toptags.page_adapters.INewsPageTopWordsWithLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class HTMLService {

//    @Value("${timeCheck}")
//    private String lockalTime;

    @Autowired
    private CheckTime checkTime;

    public String getHTML(List<INewsPageTopWordsWithLink> pageList) {

        String htmlCode;

        htmlCode = "" + "<!DOCTYPE html><html><body><table width = \"100%\"><tbody>" +
                "<tr><td align = \"center\"><h2>Top Tags from News Pages</h2></td></tr>";

        htmlCode += "<tr><td><p align = \"center\">Data update CheckTime: " + checkTime.getTime() + "</h2></td></tr>";
        htmlCode += "<tr><td align= \"center\"><table><tbody align = \"justify\">";

        htmlCode += addWebPageToTitle(pageList);

        htmlCode += getDataFromArray(pageList);

        htmlCode += "</td></tr></tbody></table></body></html>";

        return htmlCode;
    }


    private String addWebPageToTitle(List<INewsPageTopWordsWithLink> pageList) {
        String html = "";
        html += "<tr>";

        for (int j = 0; j < pageList.size(); j++) {

            html += "<td>";

            html += "<b>" + pageList.get(j).getWebDomain() + "</b>";

            html += "</td>";
        }
        html += "</tr>";

        return html;
    }

    private String getDataFromArray(List<INewsPageTopWordsWithLink> pageList) {
        String html = "";

        for (int i = 0; i < pageList.get(0).getFilteredTopWordsArray().length; i++) {

            html += "<tr>";

            html += addDataFromArrayCell(pageList, i);

            html += "</tr>";
        }

        return html;
    }


    private String addDataFromArrayCell(List<INewsPageTopWordsWithLink> pageList, int i) {
        String html = "";

        for (int k = 0; k < pageList.size(); k++) {
            html += "<td>";

            html += (pageList.get(k)).getFilteredTopWordsArray()[i];

            html += "</td>";
        }

        return html;
    }

}
