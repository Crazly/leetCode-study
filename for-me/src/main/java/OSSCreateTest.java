import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class OSSCreateTest {
    public static String accessKey = "SsH5vHOCnsBo46tgKXrpj6sNE2F-e0dA2aU5SNtc";
    public static String secretKey = "vEOTLpZJ5CXHjjzMBnaV1BC0ULMaknj0f_Ze91yf";
    public static String bucket = "bajanju-p";
    public static void main(String[] args) throws Exception{
//        客户端： https://developer.qiniu.com/kodo/tools/5972/kodo-browser
//
//        AccessKey = SsH5vHOCnsBo46tgKXrpj6sNE2F-e0dA2aU5SNtc
//
//        SecretKey = vEOTLpZJ5CXHjjzMBnaV1BC0ULMaknj0f_Ze91yf

        uploadFile();
//        upload01File();


    }

    /**
     * 普通凭证
     */
    public static void upToken(){
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
    }
    /**
     * 覆盖上传的凭证
     * 覆盖上传除了需要简单上传所需要的信息之外,还需要想进行覆盖的文件名称,这个文件名称同时可是客户端上传代码中指定的文件名,两者必须一致。
     */
    public static void overupToken(){
        String key = "file key";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        System.out.println(upToken);
    }

    /**
     * 覆盖上传
     */
    public static  void uploadFile(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证,然后准备上传

        //如果是Windows情况下,格式是 D:\\qiniu\\test.png
        String localFilePath = "/Users/yangjc/Downloads/商品供应商关系表导入模板.xlsx";
        //默认不指定key的情况下,以文件内容的hash值作为文件名
        String key = "FqXStmCYk4MdnJ2sC_lq2y8Wn3Wl";
//        https://res1.bnq.com.cn/FnynoOOzQ8h824-YcUGPq1-mjhHS?attname=%e4%b8%b4%e9%87%87%e4%bf%ae%e6%94%b9%e6%a8%a1%e6%9d%bf.xlsx&a=1622117633417
        // 普通模板 FvLlfw9FY2u0A-uL0h2X6VWv0ul7
        //临采 9a31be97-2436-451b-8067-7f60060632e9
        //区域禁售模板 Fr9x_dw4ab-C7alDC2qjiyJ81zU9

        //临采修改模板 FnynoOOzQ8h824-YcUGPq1-mjhHS
        //平台商品修改模板 FixvOx4epJEUdrQuW3x_hnnEyNDa
        //平台商品新增模板 FrsVSx0wsc03_ndjKRA9L2lnmXHT


        //商品&供应商关系表导入模板 FqXStmCYk4MdnJ2sC_lq2y8Wn3Wl
        Auth auth = Auth.create(accessKey, secretKey);
        //覆盖上传的凭证
        String upToken = auth.uploadToken(bucket,key);

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            JSONObject json = new JSONObject(response.bodyString());
            System.out.println(json.toString());
            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

    }

    /**
     * 普通上传
     */
    public static  void upload01File(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证,然后准备上传

        //如果是Windows情况下,格式是 D:\\qiniu\\test.png
        String localFilePath = "C:\\Users\\Administrator\\Desktop\\平台商品新增模板.xlsx";
        //默认不指定key的情况下,以文件内容的hash值作为文件名
        Auth auth = Auth.create(accessKey, secretKey);
        //普通上传的凭证
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(localFilePath, null, upToken);
            JSONObject json = new JSONObject(response.bodyString());
            System.out.println(json.toString());
            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

    }
}
