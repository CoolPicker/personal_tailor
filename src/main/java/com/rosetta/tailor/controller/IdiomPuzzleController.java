package com.rosetta.tailor.controller;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.rosetta.tailor.entity.Code;
import com.rosetta.tailor.entity.Ret;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

@Api(tags = "成语接龙")
@RestController
@RequestMapping("/idiom")
public class IdiomPuzzleController {

    private static final String IdiomDictPath = "/data/rosetta/config/coal_dict.txt";
    private static final ConcurrentHashMap<String,String> pinyinIdiomMap = new ConcurrentHashMap<>(); // key为首拼音
    private static final ConcurrentHashMap<String,String> charIdiomMap = new ConcurrentHashMap<>(); // key为首字
    private static final ConcurrentLinkedDeque<String> idioms = new ConcurrentLinkedDeque<>();

    static {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(IdiomDictPath)));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                idioms.add(line);
                // 拼音map
                String[] pinyins = convertToPinyinStringArray(line);
                String key = pinyins[0];
                String value;
                if (pinyinIdiomMap.containsKey(key)) {
                    value = pinyinIdiomMap.get(key) + "," + line;
                } else {
                    value = line;
                }
                pinyinIdiomMap.put(key,value);
                // 汉字map
                String charKey = line.split("")[0];
                String charValue;
                if (charIdiomMap.containsKey(charKey)) {
                    charValue = charIdiomMap.get(charKey) + "," + line;
                } else {
                    charValue = line;
                }
                charIdiomMap.put(charKey,charValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @ApiOperation(value = "下一成语")
    @ApiImplicitParam(name = "sequence",value = "最小值",paramType = "path")
    @GetMapping("/next/{sequence}")
    public Ret nextIdioms(@PathVariable("sequence") String sequence) {
        boolean isIdiom = idioms.contains(sequence);
        Ret ret = new Ret();
        ret.setState(Code.SUCCESS);
        if (isIdiom) {
            ret.setData(nextIdiomList(sequence));
        } else {
            ret.setData(sequence + " - 不是成语!");
        }
        return ret;
    }

    private static List nextIdiomList(String sequence) {
        List<String> res = null;
        try {
            String[] array = convertToPinyinStringArray(sequence);
            String lastPinyin = array[array.length - 1];
            String lastChar = sequence.split("")[sequence.length() - 1];
            if (pinyinIdiomMap.containsKey(lastPinyin) && charIdiomMap.containsKey(lastChar)) {
                res = (List<String>) CollectionUtils.intersection(Arrays.asList(charIdiomMap.get(lastChar).split(",")).stream().collect(Collectors.toList()),
                        Arrays.asList(pinyinIdiomMap.get(lastPinyin).split(",")).stream().collect(Collectors.toList()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


    public static void main(String[] args) throws PinyinException {
//        String sequence = "长嫂就是母";
////        String sequence = "重新开始";
//        String[] aa = convertToPinyinStringArray(sequence);
//
//        for (String a :
//                aa) {
//            System.out.println(a);
//        }
//        List list = nextIdiomList(sequence);
//        System.out.println(list);
        String bb = "长安登科,长安居大不易,长安棋局,长安纸贵,常备不懈,长兵精通,长柄武器,长才大略,长材短用,长才短驭,长才广度,长材茂学,长材小试,怅怅不乐,长呈短叹,长城万里,唱筹量沙,昌歜羊枣,长春不老,长啜大嚼,长此以往,尝胆眠薪,尝胆卧薪,长刀鬼将,偿得夙愿,尝鼎一脔,唱对台戏,长恶不悛,长恶靡悛,倡而不和,长发其祥,肠肥满脑,肠肥脑满,长风破浪,唱高和寡,长歌代哭,长歌当哭,长歌当泣,唱红白脸,苌弘碧血,苌弘化碧,长话短说,常怀千岁忧,惝恍迷离,肠回气荡,长戟高门,长计远虑,长驾远驭,长江后浪推前浪,长江七号,长江天堑,长江天险,常将有日思无日,唱叫扬疾,畅叫扬疾,长街短巷,长颈鸟喙,长久之计,猖獗一时,长乐未央,长乐永康,常鳞凡介,长林丰草,长虑顾后,长虑后顾,长虑却顾,常骂不惊常打不怕,长蛮喽罗,长蛮探子,长蛮先锋,唱米作沙,长眠不起,长命百岁,长明灯笼,长鸣都尉,长命富贵,长目飞耳,长年累月,长念却虑,长辔远御,长辔远驭,长篇大论,长篇大套,长篇累牍,偿其大欲,长桥码头,倡情冶思,长驱而入,长驱径入,长驱深入,长驱直进,长驱直入,长驱直突,怅然若失,怅然自失,长嫂就是母,唱沙作米,长蛇封豕,长蛇焰火,长舌之妇,长身暴起,长身鹤立,长生不老,长生不灭,长生不死,长绳系日,常胜将军,长生久视,长绳系景,长首彩鹫,长寿神像,常说口里顺常做手不笨,长算远略,畅所欲为,畅所欲言,长叹不如慢磨,长谈阔论,长天大日,长添灯草满添油,长天老日,常调官好做家常饭好吃,倡条冶叶,长亭短亭,昌亭旅食,昌亭之客,畅通无阻,长途跋涉,长往远引,畅行无碍,畅行无阻,敞胸露怀,长袖善舞,长吁短气,长吁短叹,长须火枪,畅叙幽情,昌言无忌,徜徉恣肆,长夜漫漫,长夜难明,长夜之饮,长揖不拜,常在河边站哪有不湿鞋,长斋礼佛,长斋佞佛,长斋绣佛,长爪猛鹫,长枕大被,长枕大衾,长治久安,长足进展,长傲饰非,长大各乡里,长虺成蛇,长年三老,长他人志气灭自己威风,长幼有序,长幼尊卑,长者赐不敢辞,长者墓碑,长嘴泥鳅";
        String cc = "长安登科,长安居大不易,长安棋局,长安纸贵,长兵精通,长柄武器,长才大略,长材短用,长才短驭,长才广度,长材茂学,长材小试,长呈短叹,长城万里,长春不老,长啜大嚼,长此以往,长刀鬼将,长恶不悛,长恶靡悛,长发其祥,长风破浪,长歌代哭,长歌当哭,长歌当泣,长话短说,长戟高门,长计远虑,长驾远驭,长江后浪推前浪,长江七号,长江天堑,长江天险,长街短巷,长颈鸟喙,长久之计,长乐未央,长乐永康,长林丰草,长虑顾后,长虑后顾,长虑却顾,长蛮喽罗,长蛮探子,长蛮先锋,长眠不起,长命百岁,长明灯笼,长鸣都尉,长命富贵,长目飞耳,长年累月,长念却虑,长辔远御,长辔远驭,长篇大论,长篇大套,长篇累牍,长桥码头,长驱而入,长驱径入,长驱深入,长驱直进,长驱直入,长驱直突,长嫂就是母,长蛇封豕,长蛇焰火,长舌之妇,长身暴起,长身鹤立,长生不老,长生不灭,长生不死,长绳系日,长生久视,长绳系景,长首彩鹫,长寿神像,长算远略,长叹不如慢磨,长谈阔论,长天大日,长添灯草满添油,长天老日,长亭短亭,长途跋涉,长往远引,长袖善舞,长吁短气,长吁短叹,长须火枪,长夜漫漫,长夜难明,长夜之饮,长揖不拜,长斋礼佛,长斋佞佛,长斋绣佛,长爪猛鹫,长枕大被,长枕大衾,长治久安,长足进展,长傲饰非,长大各乡里,长虺成蛇,长年三老,长他人志气灭自己威风,长幼有序,长幼尊卑,长者赐不敢辞,长者墓碑,长嘴泥鳅";
        List<String> bbList = Arrays.asList(bb.split(",")).stream().collect(Collectors.toList());
        List<String> ccList = Arrays.asList(cc.split(",")).stream().collect(Collectors.toList());
        for (String b : bbList) {
            for (String c : ccList) {
                if (b.equals(c)) {
                    System.out.println(c);
                }
            }
        }
    }

    /**
     * 短句转String数组
     * @param sequence
     * @return
     */
    private static String[] convertToPinyinStringArray(String sequence) {
        String[] res = new String[sequence.length()];
        try {
            String convert = PinyinHelper
                    .convertToPinyinString(sequence
                            ,""
                            ,PinyinFormat.WITH_TONE_NUMBER);
            res = convert.split("\\d");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
