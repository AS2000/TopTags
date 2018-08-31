package com.vcs.toptags.rest_controllers;

import com.vcs.toptags.io.CheckTime;
import com.vcs.toptags.page_adapters.INewsPageTopWordsWithLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;


@Component
public class HTMLService {

    @Autowired
    private CheckTime checkTime;


    public String getHTML(List<INewsPageTopWordsWithLink> pageList) {

        return generateHTML(pageList);
    }


    private String generateHTML(List<INewsPageTopWordsWithLink> pageList){

        String htmlCode;

        htmlCode = "" + "<!DOCTYPE html><html><body><table width = \"100%\" ><tbody>" +
                "<tr><td align = \"center\"><h2>Top Tags from News Pages</h2></td></tr>";

        htmlCode += "<tr><td><p align = \"center\">Data update Time: " + checkTime.getTime() + "</p></td></tr>";
        htmlCode += "<tr><td align = \"center\"><table border style = \"border: 1px;  border-collapse: collapse\"><tbody>";

        htmlCode += addWebDomainToTitle(pageList);

        htmlCode += addWordsCheckedQtyToTitle(pageList);

        htmlCode += addUniqueWordsQtyToTitle(pageList);

        htmlCode += addDataFromArray(pageList);

//        String firstColumnData = "<span align = \"center\"><a href = \"/json\"> /json</a></span>";
//
//        String methodName = "getCheckedWordsQty()";

//        htmlCode += addLineToTable(pageList, firstColumnData, methodName);

        htmlCode += "" + "</tbody></table>" + "</td></tr></tbody></table></body></html>";

        return htmlCode;
    }

//    private String addLineToTable(List<INewsPageTopWordsWithLink> pageList, String firstColumnData, String methodName) {
//        String html = "";
//
//        html += "<tr>";
//
//        // First Column - for /json/  -all
//        html += "<td><span align = \"center\">" + firstColumnData + "</span></td>";
//
//        for (int j = 0; j < pageList.size(); j++) {
//
//            html += "<td>";
//
//            try {
//
//                html += "<b>" + (pageList.get(j)).getClass().getMethod(methodName) + "</b>";
//
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//
//            html += "</td>";
//        }
//        html += "</tr>";
//
//        return html;
//    }

    private String addWebDomainToTitle(List<INewsPageTopWordsWithLink> pageList) {
        String html = "";

        html += "<tr>";

        // First Column - for /json/  -all
        html += "<td align = \"center\"><p><a href = \"/json\">/json</a></p></td>";

        for (int j = 0; j < pageList.size(); j++) {

            html += "<td style = \"padding: 5px\">";

            html += "<b>" + pageList.get(j).getWebDomain() + "</b>";

            html += "</td>";
        }
        html += "</tr>";

        return html;
    }

    private String addWordsCheckedQtyToTitle(List<INewsPageTopWordsWithLink> pageList) {
        String html = "";

        html += "<tr>";

        // First Column
        html += "<td align = \"center\" style = \"padding: 5px\"><b>Checked<br>Words Qty.</b></td>";

        for (int j = 0; j < pageList.size(); j++) {

            html += "<td align = \"center\">";

            html += "<b>" + pageList.get(j).getCheckedWordsQty() + "</b>";

            html += "</td>";
        }
        html += "</tr>";

        return html;
    }

    private String addUniqueWordsQtyToTitle(List<INewsPageTopWordsWithLink> pageList) {
        String html = "";

        html += "<tr>";

        // First Column
        html += "<td align = \"center\" style = \"padding: 5px\"><b>Unique<br>Words Qty.</b></td>";


        for (int j = 0; j < pageList.size(); j++) {

            html += "<td align = \"center\">";

            html += "<b>" + pageList.get(j).getUniqueWordsQty() + "</b>";

            html += "</td>";
        }
        html += "</tr>";

        return html;
    }

    private String addDataFromArray(List<INewsPageTopWordsWithLink> pageList) {
        String html = "";
        int count = 1;
        for (int i = 0; i < pageList.get(0).getFilteredTopWordsArray().length; i++) {

            html += "<tr>";

            // First Column
            html += "<td align = \"center\">"+ count++ + "</td>";

            html += getDataFromArrayCell(pageList, i);

            html += "</tr>";
        }

        return html;
    }


    private String getDataFromArrayCell(List<INewsPageTopWordsWithLink> pageList, int i) {
        String html = "";

        for (int k = 0; k < pageList.size(); k++) {
            html += "<td align = \"center\">";

            html += (pageList.get(k)).getFilteredTopWordsArray()[i];

            html += "</td>";
        }

        return html;
    }

}
