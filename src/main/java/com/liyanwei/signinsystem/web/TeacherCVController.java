package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Api(tags = "教师课程视频管理")
@RestController
public class TeacherCVController {
    @Autowired
    private TeacherService teacherService;
    /*此处的参数后期换成前端请求发送来的数据*/
    @ApiOperation("添加课程视频信息")
    @RequestMapping("/addCourseVideo")
    public ObjectJson addCourseVideo(@RequestParam(value = "cname") String cname, @RequestParam(value = "tname")String tname, @RequestParam(value = "classtime")String coursetime, @RequestParam(value = "test1") MultipartFile multipartFile, HttpServletRequest request) throws IOException {

        String realPath = request.getSession().getServletContext().getRealPath("/video/");
        File dir = new File(realPath);
        if (!dir.isDirectory()) {//文件目录不存在，就创建一个
            dir.mkdirs();
        }

        try {
            String filename = multipartFile.getOriginalFilename();
            //服务端保存的文件对象
            File fileServer = new File(dir, filename);
            System.out.println("file文件真实路径:" + fileServer.getAbsolutePath());
            //2，实现上传
            multipartFile.transferTo(fileServer);
            String filePath = request.getScheme() + "://" +
                    request.getServerName() + ":"
                    + request.getServerPort()
                    + "/video/" + filename;
            //3，返回可供访问的网络路径
            teacherService.addCourseVideoService(cname,tname,coursetime,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        return objectJson;

    }


    @ApiOperation("删除课程视频信息")
    @PostMapping("/deleteCourseVideo")
    public void deleteCourseVideo(Integer vid){
        teacherService.deleteCourseVideoService(vid);
        System.out.println("删除成功");
    }

}
