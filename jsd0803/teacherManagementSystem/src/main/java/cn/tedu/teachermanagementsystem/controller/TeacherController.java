package cn.tedu.teachermanagementsystem.controller;

import cn.tedu.teachermanagementsystem.entity.Teacher;
import cn.tedu.teachermanagementsystem.utils.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class TeacherController {
    @RequestMapping("/add")
    @ResponseBody
    public String add_teacher(String name,Double salary,int age){
        try (
                Connection connection = DBUtil.getConnection();
        ){
            String sql = "insert into teacher values(null,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,salary);
            ps.setInt(3,age);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html="<a href='/'>跳转首页</a>";
        return "添加成功"+html;
    }

    @RequestMapping("/list")
    @ResponseBody
    public String teacherList(){
        ArrayList<Teacher> list = new ArrayList<>();
        try(
                Connection connection = DBUtil.getConnection();
                ){
            String sql = "select id,name,salary,age from teacher";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double salary = rs.getDouble(3);
                int age = rs.getInt(4);
                Teacher t = new Teacher();
                t.setAge(age);
                t.setId(id);
                t.setName(name);
                t.setSalary(salary);
                list.add(t);
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        String html = "<table border='1'>";
        html+="<caption>教师列表</caption>";
        html+="<tr><th>id</th><th>姓名</th<th>工资</th<th>年龄</th><th>操作</th></tr>";
        for(Teacher t:list){
            html+="<tr>";
            html+="<td>"+t.getId()+"</td>";
            html+="<td>"+t.getName()+"</td>";
            html+="<td>"+t.getSalary()+"</td>";
            html+="<td>"+t.getAge()+"</td>";
            html+="<td><a href='/delete?id="+t.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteTeacher(int id){
        try (
                Connection connection = DBUtil.getConnection();
        ){
            String sql = "delete from teacher where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<a href='/'>返回首页</a>";
        return "删除成功！"+html;
    }

    @RequestMapping("update")
    @ResponseBody
    public String updateTeacher(int id,String name,Double salary,int age){
        try (
                Connection connection = DBUtil.getConnection();
        ){
            String sql = "update teacher set name=?,salary=?,age=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,salary);
            ps.setInt(3,age);
            ps.setInt(4,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<a href='/'>返回首页</a>";
        return "修改成功！"+html;
    }

}
