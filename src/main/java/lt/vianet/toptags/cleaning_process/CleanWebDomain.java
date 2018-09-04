package lt.vianet.toptags.cleaning_process;

public class CleanWebDomain {
    public String getCleanWebDomain(String domainName){

        return cleanWebDomain(domainName);
    }

    private String cleanWebDomain(String domainName){

        if (domainName.contains("https://")) {domainName = domainName.replace("https://","");}
        if (domainName.contains("http://")) {domainName = domainName.replace("http://","");}
        if (domainName.contains("/")) {domainName = domainName.replace("/","");}

        return domainName;
    }

}
