package lt.vianet.toptags.rest_controllers;

import lt.vianet.toptags.cleaning_process.CleanWebDomain;
import lt.vianet.toptags.io.CheckTime;
import lt.vianet.toptags.page_adapters.INewsPageTopWordsWithLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

import static lt.vianet.toptags.rest_controllers.CalculationThread.SCAN_TIME;

@Component
public class HTMLService {

    @Autowired
    private CheckTime checkTime;

    @Autowired
    private Environment environment;

    private int timeOutMin;

    public String getHTML(List<INewsPageTopWordsWithLink> pageList) {

        return generateHTML(pageList);
    }


    private String generateHTML(List<INewsPageTopWordsWithLink> pageList) {

        String htmlCode;

        htmlCode = "" + "<!DOCTYPE html><html>";
        htmlCode += "<head";

        htmlCode += "" + addPageRefreshTimerTag();
        htmlCode += "" + addCSS();

        htmlCode += "</head>";

        htmlCode += "<body><table width = \"100%\"><tbody>";

        htmlCode += "" + addUpdateAndPeriodTable();

        htmlCode += "<tr><td align = \"center\" ><h2>Top Tags from News Pages</h2></td></tr>";

        htmlCode += "<tr><td align = \"center\"><table border style = \"border: 1px;  border-collapse: collapse\"><tbody>";

        htmlCode += addWebDomainToTitle(pageList);

        htmlCode += addWordsCheckedQtyToTitle(pageList);

        htmlCode += addUniqueWordsQtyToTitle(pageList);

        htmlCode += addDataFromArray(pageList);

//        String firstColumnData = "<span align = \"center\"><a href = \"/json\"> /json</a></span>";
//
//        String methodName = "getCheckedWordsQty()";

//        htmlCode += addLineToTable(pageList, firstColumnData, methodName);

        htmlCode += "</tbody></table>" + "</td></tr>";

        htmlCode += "" + addCopyright();

        htmlCode += "</tbody></table></body></html>";

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

    // Browser refresh timer: 300 sec = 5 min.
    private String addPageRefreshTimerTag() {

        return "<meta http-equiv=\"refresh\" content=\"300\">";
    }

    // Text Style - CSS
    private String addCSS() {
        String html = "";

        html += "<style> ";

        html += "td { padding: 2px; vertical-align: center; }" +
                "h2 { margin-top: 0px; margin-bottom: 0px; }";

        html += "</style>";

        return html;
    }

    private String addUpdateAndPeriodTable() {
        String html = "";

        timeOutMin = Integer.parseInt(environment.getProperty("timeOutMin"));

        html += "<tr><td align = \"right\">";
        html += "<table width = \"100%\"><tbody>";

        html += "<tr><td align = \"right\">Page refresh Time: </td><td align = \"left\">" + checkTime.getTime() + "</td></tr>";
        html += "<tr><td align = \"right\">Data scan Time: </td><td align = \"left\">" + SCAN_TIME + "</td></tr>";
        html += "<tr><td align = \"right\">Scanning timeout, min: </td><td align = \"left\">" + timeOutMin + "</td></tr>";

        html += "</tbody></table>";

        html += "</td></tr>";

        return html;
    }

    private String cleanWebDomain(String domainName) {

        return new CleanWebDomain().getCleanWebDomain(domainName);
    }

    private String addWebDomainToTitle(List<INewsPageTopWordsWithLink> pageList) {
        String html = "";

        html += "<tr>";

        // First Column - for /json/  -all
        html += "<td align = \"center\"><p><a href = \"/json\">/json</a></p></td>";

        for (int j = 0; j < pageList.size(); j++) {

            html += "<td align = \"center\">";

            html += "<a href = \"/json/" + cleanWebDomain(pageList.get(j).getWebDomain()) + "\"><b>" + cleanWebDomain(pageList.get(j).getWebDomain()) + "</b></a>";

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
        html += "<td align = \"center\" style = \"padding: 2px\"><b>Unique<br>Words Qty.</b></td>";


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
            html += "<td align = \"center\">" + count++ + "</td>";

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

    private String addCopyright() {
        String html = "";

        html += "<tr><td align = \"center\" style = \"height: 15px\"> </td></tr>";
        html += "<tr><td align = \"center\"><i>Project was created by Anton Šepetko.</i></td></tr>";
        html += "<tr><td align = \"center\">© 2018.</td></tr>";

        return html;
    }


}
