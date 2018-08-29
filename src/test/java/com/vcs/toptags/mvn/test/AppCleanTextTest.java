package com.vcs.toptags.mvn.test;

import com.vcs.toptags.cleaning_process.CleanTheText;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * HTML text cleaning to test
 */

public class AppCleanTextTest{

    private CleanTheText cleanTheText;

    @Before
    public void init(){ cleanTheText = new CleanTheText(); }

    @Test
    public void getCleanTextArray() {

        List<StringBuffer> testList = new ArrayList<StringBuffer>();
        String s = new String("<safdSD>&asdf;  home children <script>script script script</script>");
        testList.add(new StringBuffer(s.subSequence(0, s.length())));
        String s1 = new String("     </head>     <body>     text    <script  src=></script> <script defer src=></script> <script> <!--//--><![cdata[//><!-- var pp_gemius_identifier='.ahlohbs9lonbvls4stk5fwpzzzdl_byo1y1foshwmv.w7',pp_gemius_extraparameters=['channel=delfi'].concat(['dabd='+(window.__dabd&&__dabd())]);function gemius_pending(i) { window[i] = window[i] || function() {var x = window[i+'_pdata'] = window[i+'_pdata'] || []; x[x.length]=arguments;};};gemius_pending('gemius_hit'); gemius_pending('gemius_event'); gemius_pending('pp_gemius_hit'); gemius_pending('pp_gemius_event');(function(d,t) {try {var gt=d.createelement(t),s=d.getelementsbytagname(t)[0],l='http'+((location.protocol=='https:')?'s':''); gt.setattribute('async','async');gt.src=l+'://galt.hit.gemius.pl/xgemius.js'; s.parentnode.insertbefore(gt,s);} catch (e) {}})(document,'script');var dgs_gemius_identifier='cojatmclc09yxadllifrbzec.fngaprx2vzu.eu8hkh.b7'; //--><!]]> </script> ");
        testList.add(new StringBuffer(s1.subSequence(0, s.length())));

        List<String> wordsList = cleanTheText.getCleanTextArray(testList);

        assertEquals(4, wordsList.size());
        assertEquals("home", wordsList.get(0));
        assertEquals("children", wordsList.get(1));
        assertEquals("text", wordsList.get(2));
        assertEquals("script", wordsList.get(3));

    }
}
