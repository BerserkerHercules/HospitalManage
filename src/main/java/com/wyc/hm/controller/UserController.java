package com.wyc.hm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wyc.hm.entity.Dk;
import com.wyc.hm.entity.Dto.UserDto;
import com.wyc.hm.entity.User;
import com.wyc.hm.service.UserService;
import com.wyc.hm.util.DateUtil;
import com.wyc.hm.util.JsonUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Description
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:49:24
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/addDk")
    public JSONObject addDk(@RequestBody Dk dk) {
        try{
            userService.addDk(dk);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"打卡失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"打卡成功！\"}");
    }

    @RequestMapping(value = "/getDkList")
    public JSONArray getDkList(@RequestBody UserDto userDto) {
        List<UserDto> list = userService.getDkList(userDto);
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/getUserList")
    public JSONArray getUserList(@RequestBody User user) {
        List<User> list = userService.getUserList(user);
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/changeUser")
    public JSONObject changeUser(@RequestBody User user) {
        try{
            userService.changeUser(user);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"修改失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"修改成功！\"}");
    }

    @RequestMapping(value = "/addUser")
    public JSONObject addUser(@RequestBody User user) {
        try{
            userService.addUser(user);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"添加失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"添加成功！\"}");
    }

    @RequestMapping(value = "/deleteUser")
    public JSONObject deleteUser(@RequestBody User user) {
        try{
            userService.deleteUser(user);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"删除失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"删除成功！\"}");
    }

    /**
     * 导出
     */
    @RequestMapping(value = "/export")
    public void exportallDocumentaryExcel(HttpServletResponse response,UserDto userDto) throws IOException {
        try {
            List<UserDto> dkList = userService.getDkList(userDto);
            // 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
            // 内存中保留 10000 条数据，以免内存溢出，其余写入 硬盘
            SXSSFWorkbook workbook = new SXSSFWorkbook(10000);
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(XSSFCellStyle.ALIGN_CENTER);//SXSSFWorkbook方式的居中
            // 创建一个sheet页
            SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("销售订单");
            // 分别设置Excel列的宽度

            for(int i=0;i<10;i++){
                sheet.setColumnWidth(i, 4000);
            }
            // 创建标题
            SXSSFRow headRow = (SXSSFRow) sheet.createRow(0);
            headRow.createCell(0).setCellValue("姓名");
            headRow.createCell(1).setCellValue("性别");
            headRow.createCell(2).setCellValue("科室");
            headRow.createCell(3).setCellValue("手机号码");
            headRow.createCell(4).setCellValue("打卡时间");

            for (UserDto u : dkList) {

                String dateStr = DateUtil.dateToString(u.getDkTime(),"yyyy-MM-dd");
                if(DateUtil.isThisMonth(dateStr)){
                    // 创建行
                    SXSSFRow dataRow = (SXSSFRow) sheet.createRow(sheet.getLastRowNum() + 1);
                    dataRow.createCell(0).setCellValue(u.getUserName());
                    dataRow.createCell(1).setCellValue(u.getXb());
                    dataRow.createCell(2).setCellValue(u.getKs());
                    dataRow.createCell(3).setCellValue(u.getPhone());
                    dataRow.createCell(4).setCellValue(u.getDkTime());
                }
            }

            // 设置Excel文件名，并以中文进行编码
            String codedFileName = new String("本月打卡列表".getBytes("gbk"), "iso-8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + codedFileName + DateUtil.getCurrentTime2() +".xlsx");
            // 响应类型,编码
            response.setContentType("application/octet-stream;charset=UTF-8");
            // 形成输出流
            OutputStream osOut = response.getOutputStream();
            // 将指定的字节写入此输出流
            workbook.write(osOut);
            // 刷新此输出流并强制将所有缓冲的输出字节被写出
            osOut.flush();
            // 关闭流
            osOut.close();
            /*
             * dispose of temporary files backing this workbook on disk
             * 处理在磁盘上备份此工作簿的临时文件 SXSSF分配临时文件，必须始终清除显式，通过调用dispose方法
             */
            workbook.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println( "导出用户失败！失败信息："+e.getMessage());
        }
    }

}
