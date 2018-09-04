package lt.vianet.toptags.cleaning_process;

public class AllTagRemover {
    public StringBuffer getCleanText(StringBuffer buffer) {
        return cleanText(buffer);
    }


    private StringBuffer cleanText(StringBuffer buffer) {
        try {
            int start, end;

            while (buffer.indexOf("<") >= 0 && buffer.indexOf(">", buffer.indexOf("<")) > 0) {

                start = buffer.indexOf("<");
                end = buffer.indexOf(">", buffer.indexOf("<"));

                // "< >"
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
