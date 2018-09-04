package lt.vianet.toptags.cleaning_process;

public class StyleTagRemover {
    public StringBuffer getCleanText(StringBuffer buffer) {

        return cleanText(buffer);
    }


    private StringBuffer cleanText(StringBuffer buffer) {

        try {


            int start = buffer.indexOf("<style>");
            int end = buffer.indexOf("</style>", start);

            while (start > 0 && end > 0 && start < end) {


                // Delete Tags from "<style>" to "</style>"
                if ((start > 0) && (start < buffer.length()) && (start < end)) {
                    buffer.replace(start, end + 8, "");
                }
                start = buffer.indexOf("<style>");
                end = buffer.indexOf("</style>", start);
            }


            start = buffer.indexOf("<style type");
            end = buffer.indexOf("</style>", start);

            while (start > 0 && end > 0 && start < end) {


                // Delete Tags from "<<style type>" to "</style>"
                if ((start > 0) && (start < buffer.length()) && (start < end)) {
                    buffer.replace(start, end + 8, "");
                }
                start = buffer.indexOf("<style type");
                end = buffer.indexOf("</style>", start);
            }


        } catch (StringIndexOutOfBoundsException siobe) {
            System.out.println("You catched: " + siobe.getMessage());
        }
        return buffer;
    }
}
