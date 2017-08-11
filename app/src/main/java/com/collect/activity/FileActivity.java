package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.collect.R;
import com.collect.base.BaseActivity;
import com.utils.FileUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/2.
 * 学习File的使用
 */
@RouterMap({"activity://file"})
public class FileActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);


//        long start = SystemClock.currentThreadTimeMillis();
//        copyImg2();
//        long end = SystemClock.currentThreadTimeMillis();
//        System.out.println("-----------------<<<>>>--------------------时间=" + (end - start) + "毫秒");

        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void test1() throws Exception {
        String dir = FileUtil.getDir(this);
        File file = new File(dir + "/yy.txt");
        if (!file.exists()) {
            try {
                boolean newFile = file.createNewFile();
                System.out.println("-----------------<<<>>>--------------------newFile=" + newFile);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String content = "骄傲了放假奥拉夫骄傲了假两件发浪费来拉低了阿里";

//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            fileWriter.write(content);
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        FileReader fileReader = new FileReader(file);
        char[] chars = new char[2];
        int b = 0;
        while ((b = fileReader.read(chars)) != -1) {
            String str = new String(chars, 0, b);
            System.out.println("-----------------<<<>>>--------------------str=" + str);
        }
        fileReader.close();
    }

    /**
     * TODO 分隔符实现跨平台
     */
    private void kuapingtai() {
        File file = new File(FileUtil.getDir(this) + File.separator + "aaa" + File.separator + "bbb.txt");//这个可以实现所有平台
//        File file=new File(FileUtil.getDir(this)+"/aaa/bbb.txt");//这种分隔符适用于安卓,windows
    }

    /**
     * TODO 利用高效字节流复制文件
     */
    private void copyImg2() {
        String dir = FileUtil.getDir(this);
        File file = new File(dir + "/laopo.jpg");
        File copyFile = new File(dir + "/laopoCopy.jpg");
        if (!file.exists()) {
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(copyFile));

            int b = 0;
            while ((b = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * TODO 利用普通字节流复制文件
     */
    private void copyImg() {
        String dir = FileUtil.getDir(this);
        File file = new File(dir + "/laopo.jpg");
        File copyFile = new File(dir + "/laopoCopy.jpg");
        if (!file.exists()) {
            return;
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(copyFile);

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * TODO  fileOutputStream 写
     *
     * @param file
     */
    private void fileOutputStream(File file) {
        try {
            String content = "adfadfadfadf;jljk";
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * TODO FileInputStream 读
     *
     * @param file
     */
    private void fileInputStream(File file) {
        try {
            byte[] bytes = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                String string = new String(bytes, 0, len);
                System.out.println("-----------------<<<>>>--------------------string=" + string);
            }
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO FileWriter高效读入流
     *
     * @param file
     * @throws IOException
     */
    private void butterWriter(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.close();//这个关闭就是关闭流
    }

    private void fileReaderToFile2(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            char[] chars = new char[2];
            int num = 0;
            while ((num = fileReader.read(chars)) != -1) {
                String string = new String(chars, 0, num);
                System.out.println("-----------------<<<>>>--------------------str=" + string);
            }
            fileReader.close();//这样关闭非标准
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void fileReaderToFile(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
//                ch = fileReader.read();
                System.out.println("-----------------<<<>>>--------------------ch=" + (char) ch);
            }
            fileReader.close();//这样关闭非标准
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
      TODO  这个可以获取手机的存储根目录
     */
    private void getDir() {
        String dir = FileUtil.getDir(this);
    }

    /*
    TODO 通过这个可以创建单个目录文件夹
    */
    private void creatSingleFiles() {
        String dir = FileUtil.getDir(this);

        File file = new File(dir, "aaa");
        if (!file.exists()) {
            boolean mkdir = file.mkdir();
            System.out.println("-----------------<<<>>>--------------------mkdir=" + mkdir);
        }
    }

    /*
        TODO 通过这个可以创建单个文件,前提是所属文件目录表存在
         */
    private void creatSingleFile() {
        String dir = FileUtil.getDir(this);

        File file = new File(dir, "aaa");
        if (!file.exists()) {
            boolean mkdir = file.mkdir();
            System.out.println("-----------------<<<>>>--------------------mkdir=" + mkdir);
        }
        File file1 = new File(file, "ccc.txt");
        if (!file1.exists()) {
            try {
                boolean newFile = file1.createNewFile();
                System.out.println("-----------------<<<>>>--------------------newFile=" + newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * TODO 通过这个可以把字符流写入文件,如果该文件不存在,则创建文件,前提是所属文件目录表存在
     * TODO  fileWriter.close();//这个关闭前刷新流
     */
    private void fileWriterToFile() {
        String dir = FileUtil.getDir(this);

        File file = new File(dir, "aaa");
        if (!file.exists()) {
            boolean mkdir = file.mkdir();
            System.out.println("-----------------<<<>>>--------------------mkdir=" + mkdir);
        }


        File file1 = new File(file, "ccc.txt");
        if (!file1.exists()) {
            try {
                boolean newFile = file1.createNewFile();
                System.out.println("-----------------<<<>>>--------------------newFile=" + newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * TODO 以下操作是一个标准的关闭IO流的操作
         */
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file1);
//            fileWriter = new FileWriter(file1,true);//TODO 第二个参数表示是否在该文件后续写数据
            fileWriter.write("大家好啊");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
