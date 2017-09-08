//package com.collect.activity;
//
//import android.os.Bundle;
//import android.os.Looper;
//import android.support.annotation.Nullable;
//
//import com.collect.R;
//import com.collect.base.BaseActivity;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import cn.campusapp.router.annotation.RouterMap;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
///**
// * Created by zhangyuncai on 2017/8/12.
// */
//@RouterMap("activity://http")
//public class HttpActivity extends BaseActivity {
//
//    private OkHttpClient mOkHttpClient;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_http);
//
//
////        visitIntnetForGet("http://www.baidu.com");
//
////        getHttpClient();
//
////        visitOkhttp("http://www.baidu.com");
//    }
//
//    public void visitOkhttp(final String url) {
//        mOkHttpClient = new OkHttpClient();
//        Request.Builder builder = new Request.Builder().url(url);
//        builder.method("GET", null);
//        Request request = builder.build();
//        Call call = mOkHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//            }
//        });
//
//    }
//
//    /*---------------------------HttpUrlConnection--------------------------start*/
//    public void visitIntnetForGet(final String url) {
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    URL mUrl = new URL(url);
//                    HttpURLConnection urlConnection = (HttpURLConnection) mUrl.openConnection();
//                    if (200 == urlConnection.getResponseCode()) {
//                    }
////                    urlConnection.setRequestMethod("GET");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
////
////                HttpURLConnection httpURLConnection = getHttpURLConnection(url);
////                try {
////                    httpURLConnection.connect();
////                    Object content = httpURLConnection.getContent();
//////                    StringBuffer stringBuffer = new StringBuffer();
//////                    byte[] bytes = new byte[1024];
//////                    int b = 0;
//////                    InputStream inputStream = httpURLConnection.getInputStream();
//////
//////                    while ((b = inputStream.read(bytes)) != -1) {
//////                        String string = new String(bytes, 0, bytes.length);
//////                        stringBuffer.append(string);
//////                    }
//////                    inputStream.close();
//////
//////                    int responseCode = httpURLConnection.getResponseCode();
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//            }
//        }.start();
//    }
//
//    public static HttpURLConnection getHttpURLConnection(String url) {
//        HttpURLConnection mHttpURLConnection = null;
//        try {
//            URL mUrl = new URL(url);
//            mHttpURLConnection = (HttpURLConnection) mUrl.openConnection();
//            //设置链接超时时间
//            mHttpURLConnection.setConnectTimeout(15000);
//            //设置读取超时时间
//            mHttpURLConnection.setReadTimeout(15000);
//            //设置请求参数
//            mHttpURLConnection.setRequestMethod("GET");
//            //添加Header
//            mHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
////            //接收输入流
////            mHttpURLConnection.setDoInput(true);
////            //传递参数时需要开启
////            mHttpURLConnection.setDoOutput(true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return mHttpURLConnection;
//    }
//     /*---------------------------HttpUrlConnection--------------------------end*/
//
//    /*--------------------------------HttpClient------------------------------start*/
//
////    /**
////     * TODO 访问httpclient
////     * 记得在APP.build文件添加这句android {
////     * useLibrary 'org.apache.http.legacy'
////     * }
////     */
////    private void getHttpClient() {
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                useHttpClientGet("http://www.baidu.com");
////            }
////        }).start();
////    }
////
////
////    //创建HttpClient
////    private HttpClient createHttpClient() {
////        HttpParams mDefaultHttpParams = new BasicHttpParams();
////        //设置连接超时
////        HttpConnectionParams.setConnectionTimeout(mDefaultHttpParams, 15000);
////        //设置请求超时
////        HttpConnectionParams.setSoTimeout(mDefaultHttpParams, 15000);
////        HttpConnectionParams.setTcpNoDelay(mDefaultHttpParams, true);
////        HttpProtocolParams.setVersion(mDefaultHttpParams, HttpVersion.HTTP_1_1);
////        HttpProtocolParams.setContentCharset(mDefaultHttpParams, HTTP.UTF_8);
////        //持续握手
////        HttpProtocolParams.setUseExpectContinue(mDefaultHttpParams, true);
////        HttpClient mHttpClient = new DefaultHttpClient(mDefaultHttpParams);
////        return mHttpClient;
////    }
////
////    /**
////     * Get请求
////     *
////     * @param url
////     */
////    private void useHttpClientGet(String url) {
////        HttpGet mHttpGet = new HttpGet(url);
////        mHttpGet.addHeader("Connection", "Keep-Alive");
////        try {
////            HttpClient mHttpClient = createHttpClient();
////            HttpResponse mHttpResponse = mHttpClient.execute(mHttpGet);
////            HttpEntity mHttpEntity = mHttpResponse.getEntity();
////            int code = mHttpResponse.getStatusLine().getStatusCode();
////            if (null != mHttpEntity) {
////                InputStream mInputStream = mHttpEntity.getContent();
////                String respose = converStreamToString(mInputStream);
////                Log.i("wangshu", "请求状态码:" + code + "\n请求结果:\n" + respose);
////                mInputStream.close();
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
////
////    /**
////     * Post请求
////     *
////     * @param url
////     */
////    private void useHttpClientPost(String url) {
////        HttpPost mHttpPost = new HttpPost(url);
////        mHttpPost.addHeader("Connection", "Keep-Alive");
////        try {
////            HttpClient mHttpClient = createHttpClient();
////            List<NameValuePair> postParams = new ArrayList<>();
////            //要传递的参数
////            postParams.add(new BasicNameValuePair("username", "moon"));
////            postParams.add(new BasicNameValuePair("password", "123"));
////            mHttpPost.setEntity(new UrlEncodedFormEntity(postParams));
////            HttpResponse mHttpResponse = mHttpClient.execute(mHttpPost);
////            HttpEntity mHttpEntity = mHttpResponse.getEntity();
////            int code = mHttpResponse.getStatusLine().getStatusCode();
////            if (null != mHttpEntity) {
////                InputStream mInputStream = mHttpEntity.getContent();
////                String respose = converStreamToString(mInputStream);
////                Log.i("wangshu", "请求状态码:" + code + "\n请求结果:\n" + respose);
////                mInputStream.close();
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
////
////    private String converStreamToString(InputStream is) throws IOException {
////        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
////        StringBuffer sb = new StringBuffer();
////        String line = null;
////        while ((line = reader.readLine()) != null) {
////            sb.append(line + "\n");
////        }
////        String respose = sb.toString();
////        return respose;
////    }
//
//    /*--------------------------------HttpClient------------------------------end*/
//}
