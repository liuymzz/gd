package com.lym.gd.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lym.gd.DTO.CheckWorkDTO;
import com.lym.gd.DTO.UserWorkCourseDTO;
import com.lym.gd.DTO.WorkDetailDTO;
import com.lym.gd.entity.Course;
import com.lym.gd.entity.StudentWork;
import com.lym.gd.entity.StudentWorkAttachment;
import com.lym.gd.entity.Work;
import com.lym.gd.service.CourseService;
import com.lym.gd.service.WorkService;
import com.lym.gd.utils.IdUtils;
import com.lym.gd.utils.ResultVOUtil;
import com.lym.gd.vo.ResultVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 作业相关Controller
 *
 * @author liuyaming
 * @date 2018/4/18 下午3:07
 */
@Controller
public class WorkController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private WorkService workService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/publishWork")
    public String publishWorkView(Model model){

        // 需要给出当前用户已开课并且未结课的所有课程
        List<Course> courses = courseService.getStartAndNotFinishCourse();

        model.addAttribute("courses",courses);

        return "other/publishWork";
    }

    @PostMapping("/publishWork")
    @ResponseBody
    public ResultVO publishWork(@RequestBody JSONObject jsonObject){
        ResultVO resultVO = ResultVOUtil.success();

        workService.publishWork(jsonObject);

        resultVO.setMessage("发布成功");

        return  resultVO;
    }

    @GetMapping("/work")
    public String workView(Model model,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize){

        PageInfo<UserWorkCourseDTO> pageInfo = workService.getUserWorkByUser(page,pageSize);

        model.addAttribute("pageInfo",pageInfo);

        return "other/work";
    }

    @GetMapping("/work/{id}")
    public String workDetail(@PathVariable("id") String workId,Model model){

        WorkDetailDTO workDetailDTO = workService.getWorkDetail(workId);

        model.addAttribute("workDetailDTO",workDetailDTO);

        return "other/workDetail";
    }

    @GetMapping("/doWork/{id}")
    public String doWorkView(@PathVariable("id") String workId, Model model){

        Work work = workService.getNormalWork(workId);

        if (work == null){
            return "redirect:/404";
        }

        model.addAttribute("work",work);

        return "other/doWork";
    }

    @PostMapping("/doWork")
    @ResponseBody
    public ResultVO doWork(@RequestBody JSONObject jsonObject){
        ResultVO resultVO = ResultVOUtil.success();

        StudentWork studentWork = new StudentWork.Builder()
                .studentWorkId(IdUtils.getStudentWorkId())
                .studentWorkContent(jsonObject.getString("workContent"))
                .workId(jsonObject.getString("workId"))
                // 默认为未批阅状态
                .studentWorkStatus("1")
                .studentWorkSubmitDate(new Date())
                .studentWorkUserId(IdUtils.getUserId(httpSession))
                .build();

        String workAttachmentUrl = jsonObject.getString("workAttachmentUrl");
        String fileName = workAttachmentUrl.substring(workAttachmentUrl.indexOf("#") + 3);
        workAttachmentUrl = workAttachmentUrl.replace("#","%23");

        StudentWorkAttachment studentWorkAttachment = new StudentWorkAttachment.Builder()
                .studentWorkAttachmentId(IdUtils.getStudentWorkAttachmentId())
                .studentWorkId(studentWork.getStudentWorkId())
                .studentWorkAttachmentName(fileName)
                .studentWorkAttachmentUrl(workAttachmentUrl)
                .build();

        workService.doWork(studentWork,studentWorkAttachment);

        return resultVO;
    }

    @GetMapping("/checkWork")
    public String checkWork(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(name = "workId",required = false) String workId,Model model){

        PageInfo<CheckWorkDTO> pageInfo = workService.getCheckWorkDTO(workId,pageNum,pageSize);

        model.addAttribute("pageInfo",pageInfo);

        List<Course> courses = courseService.getStartAndNotFinishCourse();
        model.addAttribute("courses",courses);

        return "other/checkWork";
    }

    @GetMapping("/works")
    @ResponseBody
    public ResultVO getWorks(@RequestParam(name = "courseId") String courseId){
        ResultVO resultVO = ResultVOUtil.success();

        List<Work> works = workService.findWorksByCourseId(courseId);
        resultVO.setData(works);

        return resultVO;
    }
}
