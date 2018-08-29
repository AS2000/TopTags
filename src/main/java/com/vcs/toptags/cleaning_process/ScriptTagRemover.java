package com.vcs.toptags.cleaning_process;


public class ScriptTagRemover {
    public StringBuffer getCleanText(StringBuffer buffer) {

        return cleanText(buffer);
    }


    private StringBuffer cleanText(StringBuffer buffer) {
        try {

            // delete <script >....</script>
            int start = buffer.indexOf("<script type=");
            int end = buffer.indexOf("</script>", start);

            while (start > 0 && end > 0 && start < end) {

                // "<script "
                if ((start > 0) && (start < buffer.length()) && (start < end)) {
                    buffer.replace(start, end + 9, "");
                }

                start = buffer.indexOf("<script type=");
                end = buffer.indexOf("</script>", start);
            }


            // delete <script>....</script>
            start = buffer.indexOf("<script>");
            end = buffer.indexOf("</script>", start);

            while (start > 0 && end > 0 && start < end) {

                // "<script "
                if ((start > 0) && (start < buffer.length()) && (start < end)) {
                    buffer.replace(start, end + 9, "");
                }

                start = buffer.indexOf("<script>");
                end = buffer.indexOf("</script>", start);
            }

        } catch (StringIndexOutOfBoundsException siobe) {
            System.out.println("You catched: " + siobe.getMessage());
        }
        return buffer;
    }
}
