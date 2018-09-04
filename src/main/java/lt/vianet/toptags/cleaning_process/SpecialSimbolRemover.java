package lt.vianet.toptags.cleaning_process;

public class SpecialSimbolRemover {

    public StringBuffer getCleanText(StringBuffer buffer) {
        return cleanText(buffer);
    }

    private StringBuffer cleanText(StringBuffer buffer) {
        try {
            int start, end;

            // remove when the length of special simbol i.e. &nbsp; is less then 7 simbols
            while (buffer.indexOf("&") >= 0 && buffer.indexOf(";", buffer.indexOf("&")) > 0 && (buffer.indexOf(";", buffer.indexOf("&")) - buffer.indexOf("&")) < 8) {

                start = buffer.indexOf("&");
                end = buffer.indexOf(";", buffer.indexOf("&"));

                // "&...;"
                if ((start >= 0) && (start < buffer.length()) && (start < end)) {
                    buffer.replace(start, end + 1, " ");
                }
            }
        } catch (StringIndexOutOfBoundsException siobe) {
            System.out.println("You catched: " + siobe.getMessage());
        }
        return buffer;
    }

}
