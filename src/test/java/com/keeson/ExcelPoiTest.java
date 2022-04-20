package com.keeson;



import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.keeson.mapper.ExcelPoiMapper;
import com.keeson.mapper.UserMapper;
import com.keeson.vo.ExcelPoi;
import com.keeson.vo.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@SpringBootTest
public class ExcelPoiTest {


    @Autowired
    private ExcelPoiMapper excelPoiMapper;

    @Autowired
    private UserMapper userMapper;



    @Test
    void test1() throws IOException {
        List<ExcelPoi> excelPois = excelPoiMapper.selectList(null);
        excelPois.forEach(System.out::println);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("导出测试","sheet1"),ExcelPoi.class,excelPois);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Jeff.zheng.SOFTIDE\\Desktop\\excelPois.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }



    @Test
    void test2() throws IOException {
        List<User> users = userMapper.selectList(null);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户","user"),User.class,users);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Jeff.zheng.SOFTIDE\\Desktop\\users.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }


}
