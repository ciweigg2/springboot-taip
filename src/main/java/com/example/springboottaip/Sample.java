package com.example.springboottaip;

import cn.xsshome.taip.face.TAipFace;
import cn.xsshome.taip.imageclassify.TAipImageClassify;
import cn.xsshome.taip.nlp.TAipNlp;
import cn.xsshome.taip.ocr.TAipOcr;
import cn.xsshome.taip.ptu.TAipPtu;
import cn.xsshome.taip.speech.TAipSpeech;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.vision.TAipVision;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 马秀成
 * @date 2018/11/13
 * @jdk.version 1.8
 * @desc
 */
public class Sample {

    //设置APPID/APP_KEY
    public static final String APP_ID = "2109692408";
    public static final String APP_KEY = "AfRdgyC8zYOhyazG";

    /**
     * OCR示例代码
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        // 初始化一个TAipOcr
        TAipOcr aipOcr = new TAipOcr(APP_ID,APP_KEY);
        // 调用接口
        String result = aipOcr.idcardOcr("C:\\Users\\Ciwei\\Desktop\\微信图片_20181113173901.jpg", 0);//身份证正面(图片)识别
//        String result = aipOcr.idcardOcr("./idcard2.jpg", 1);//身份证反面(国徽)识别
//        String result = aipOcr.bcOcr("./juli2.jpg");//名片识别
//        String result = aipOcr.driverlicenseOcr("./driver.jpg",0);//行驶证OCR识别
//        String result = aipOcr.driverlicenseOcr("./driver2.jpg",1);//驾驶证OCR识别
//        String result = aipOcr.bizlicenseOcr("./biz.jpg");//营业执照OCR识别
//        String result = aipOcr.creditcardOcr("./bank2.jpg");//银行卡OCR识别
//        String result = aipOcr.generalOcr("./biz.jpg");//通用OCR识别
//        String result = aipOcr.handWritingOcrByImage("./biz.jpg");//手写体识别 选取本地图片文件识别
//        String result = aipOcr.handWritingOcrByUrl("https://yyb.gtimg.com/ai/assets/ai-demo/small/hd-1-sm.jpg");//手写体识别 选取网络图片URL识别
//        String result = aipOcr.plateOcrByImage("./biz.jpg");//车牌识别 选取本地图片文件识别
//        String result = aipOcr.plateOcrByUrl("https://yyb.gtimg.com/ai/assets/ai-demo/large/plate-1-lg.jpg");//车牌识别 选取网络图片URL识别
        System.out.println(result);
    }

    /**
     * ASR、TTS示例代码
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        // 初始化一个TAipSpeech
        TAipSpeech aipSpeech = new TAipSpeech(APP_ID, APP_KEY);
        // 调用接口
        String filePath ="./VOICE1513237078.pcm";//本地文件路径
        byte[] audio = FileUtil.readFileByBytes(filePath);//获取文件的byte数据
        String result = aipSpeech.asrEcho(filePath, 1);//语音识别-echo版
//        String result = aipSpeech.asrLab(1, 16000, 0, 1024, 1, audio);//语音识别-流式版（AI Lab）
//        String result = aipSpeech.asrWx(filePath, 1, 16000, 16, 0, 1024, 1, 1);//语音识别-流式版(WeChat AI)
//        String text = "小帅封装代码";
//        String result = aipSpeech.TtaSynthesis(text);//语音合成（优图）     默认参数
//        String result = aipSpeech.TtaSynthesis(text,2,1);//语音合成（优图）     全部参数
//        String result = aipSpeech.TtsSynthesis(text, 1, 3);//语音合成（AI Lab） 默认参数
//        String result = aipSpeech.TtsSynthesis(text,1,3,0,100,0,58);//语音合成（AI Lab） 全部参数
//        String result = aipSpeech.asrLong("G:/16.pcm", 1, "http://yourwebsitename.com/methodname");//长语音识别
//        String result = aipSpeech.aaiDetectkeywordBySpeech(filePath, 1, "http://www.xxxxx.com//txnotify", "小",8000);//关键词检索基于本地语音文件
//        String result = aipSpeech.aaiDetectkeywordBySpeechURL("http://www.xxxxx.com/audio.pcm", 1, "http://www.xxxxx.com//txnotify", "小",8000);//关键词检索基于语音URL文件
        System.out.println(result);
    }

    /**
     * 图像识别 示例代码
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        // 初始化一个TAipImageClassify
        TAipImageClassify aipImageClassify = new TAipImageClassify(APP_ID, APP_KEY);
        String filePath = "G:/x5.jpg";//本地文件路径
        byte[] image = FileUtil.readFileByBytes(filePath);//获取文件的byte数据
        String result = aipImageClassify.visionScener(image, 1, 5);//场景识别
//        String result = aipImageClassify.visionObjectr(image, 1, 5);//物体识别
//        String result = aipImageClassify.imageTag(image);//图像标签识别
//        String result = aipImageClassify.visionImgidentify(image, 1);//车辆识别
//        String result = aipImageClassify.visionImgidentify(image, 2);//花草识别
//        String result = aipImageClassify.flowersAndPlant(image);//花草识别
//        String result = aipImageClassify.vehicle(image);//车辆识别
//        String result = aipImageClassify.visionImgtotext(image,RandomNonceStrUtil.getRandomString());//看图说话
//        String result = aipImageClassify.imageFuzzy(image);//模糊图片检测
//        String result = aipImageClassify.imageFood(image);//美食图片识别
        System.out.println(result);
    }

    /**
     * 图片特效
     *
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        // 初始化一个TAipPtu
        TAipPtu aipPtu = new TAipPtu(APP_ID, APP_KEY);
        String imagePath = "G:/test2.jpg";
        String result = aipPtu.faceCosmetic(imagePath, 23);//人脸美妆
//        String result = aipPtu.faceDecoration(imagePath, 8);//人脸变妆
//        String result = aipPtu.imgFilter(imagePath, 20);//滤镜 天天P图
//        String result = aipPtu.visionImgfilter(imagePath, 32, String.valueOf(new Date().getTime()));//滤镜 AI Lab
//        String result = aipPtu.faceMerge(imagePath, 12);//人脸融合
//        String result = aipPtu.faceSticker(imagePath, 27);//大头贴
//        String result = aipPtu.faceAge(imagePath);//颜龄检测
        System.out.println(result);
    }

    /**
     * 人脸识别
     *
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {
        // 初始化一个TAipPtu
        TAipFace aipFace = new TAipFace(APP_ID, APP_KEY);
        String filePath = "G:/body2.jpg";
        String filePathA = "C:\\Users\\Ciwei\\Desktop\\1.jpg";
        String filePathB = "C:\\Users\\Ciwei\\Desktop\\2.jpg";
        /**********人脸识别**********/
//        String result = aipFace.detect(filePath);//人脸检测与分析
//        String result = aipFace.detectByUrl("https://yyb.gtimg.com/aiplat/static/ai-demo/small/f-3.jpg");//人脸检测与分析使用image_url参数
//        String result = aipFace.detectMulti(filePath);    //多人脸检测
        String result = aipFace.faceCompare(filePathA, filePathB);    //人脸对比
//        String result = aipFace.detectCrossage(filePathA, filePathB);//跨年龄人脸识别
//        String result = aipFace.faceShape(filePathA);//五官定位
//        String result = aipFace.faceIdentify(filePath, "group01", 9);//人脸识别
//        String result = aipFace.faceVerify(filePath, "20180511");//人脸验证
//        /**********个体管理**********/
//        String result = aipFace.faceNewperson(filePath,"group20180511","201805110001","测试");//个体创建
//        String result = aipFace.faceDelperson("201805110001");//删除个体
//        /*增加人脸 图片二进制List*/
//        List<byte[]> bytes = new ArrayList<byte[]>();
//        byte [] faceA = FileUtil.readFileByBytes(filePathA);
//        byte [] faceB = FileUtil.readFileByBytes(filePathB);
//        bytes.add(faceA);
//        bytes.add(faceB);
//        String result = aipFace.faceAddfaceByte(bytes,"201805110001","测试增加人脸");
//        /*增加人脸 图片本地路径List*/
//        List<String> filePaths = new ArrayList<String>();
//        filePaths.add(filePathA);
//        filePaths.add(filePathB);
//        String result = aipFace.faceAddfaceByFilePath(filePaths,"201805110001","测试增加人脸");//增加人脸
//        String result = aipFace.faceDelFace("201805110001", "2573556034542000336");//删除人脸
//        String result = aipFace.faceSetInfo("201805110001", "小帅测试","测试接口");//设置信息
//        String result = aipFace.faceGetInfo("201805110001");//获取信息
//        /**********信息查询**********/
//        String result = aipFace.getGroupIds();//获取组列表
//        String result = aipFace.getPersonIds("group20180511");//获取个体列表
//        String result = aipFace.getFaceIds("201805110001");//获取人脸列表
//        String result = aipFace.getFaceInfo("2573564663139686751");//获取人脸信息
        System.out.println(result);
    }

    /**
     * 自然语言处理
     *
     * @throws Exception
     */
    @Test
    public void test6() throws Exception {
        TAipNlp aipNlp = new TAipNlp(APP_ID, APP_KEY);
        String session = System.currentTimeMillis()+"";
        String filePath = "G:/tt.jpg";
        String filePath2 = "G:/16.pcm";
        String result = aipNlp.nlpWordseg("小帅开发者");//分词
//        String result = aipNlp.nlpWordpos("小帅是一个热心的开发者");//词性标注
//        String result = aipNlp.nlpWordner("最近张学友在深圳开了一场演唱会");//专有名词
//        String result = aipNlp.nlpWordsyn("今天的天气怎么样");//同义词
//        String result = aipNlp.nlpWordcom("今天深圳的天气怎么样？明天呢");//意图成分
//        String result = aipNlp.nlpTextpolar("小帅很帅");//情感分析
//        String result = aipNlp.nlpTextchat(session,"北京天气");//基础闲聊
//        String result = aipNlp.nlpTextTrans(0, "小帅开发者");//文本翻译（AI Lab）
//        String result = aipNlp.nlpTextTranslate("小帅开发者", "zh", "en");//文本翻译（翻译君）
//        String result = aipNlp.nlpImageTranslate(filePath, session, "doc","zh", "en");//图片翻译
//        String result = aipNlp.nlpSpeechTranslate(6, 0, 1, session, filePath2,"zh", "en");//语音翻译
//        String result = aipNlp.nlpTextDetect("こんにちは", 0);//语种识别
        System.out.println(result);
    }

    /**
     * 智能鉴黄、暴恐图片识别
     *
     * @throws Exception
     */
    @Test
    public void test7() throws Exception {
        TAipVision aipVision = new TAipVision(APP_ID, APP_KEY);
        String filePath = "G:/tt.jpg";
        String imageUrl = "https://www.xsshome.cn/xxx.jpg";//图片的网络路径地址
        String result = aipVision.imageTerrorism(imageUrl);//暴恐图片
//        String result = aipVision.imageTerrorismByURL(filePath);//暴恐图片ByURL
//        String result = aipVision.visionPorn(filePath);//智能鉴黄
//        String result = aipVision.visionPornByURL(imageUrl);//智能鉴黄ByURL
//        String speech_url = "https://www.xsshome.cn/output.mp3";
//        String result = aipVision.aaiEvilAudio(UUID.randomUUID().toString().replace("-", ""), speech_url);//音频鉴黄
        System.out.println(result);
    }

}
