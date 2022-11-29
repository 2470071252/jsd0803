package cn.tedu.teachermangementsystem.controller;

import cn.tedu.teachermangementsystem.entity.Emp;
import cn.tedu.teachermangementsystem.uitls.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class EmpController {

    @RequestMapping("/add")
    @ResponseBody
    public String add_emp(String name,int age,String job){
        try (
                Connection connection = DBUtil.getConnection();
        ){
            String sql = "insert into  myemp values (null,?,?,?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setString(3,job);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "添加成功";
    }

    @RequestMapping("/emp_list")
    @ResponseBody
    public String select_emp(){
        ArrayList<Emp> list = new ArrayList<>();
        try (
                Connection connection = DBUtil.getConnection();
        ){
            String sql = "select id,name,age,job from myemp";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String job = rs.getString(4);
                Emp e = new Emp();
                e.setId(id);
                e.setAge(age);
                e.setJob(job);
                e.setName(name);
                list.add(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<table border='1'>";
        html+="<caption>员工信息<caption>";
        html+="<tr><th>id</th><th>姓名</th><th>年龄</th><th>工作岗位</th><th>操作</th></tr>";
        for (Emp e : list) {
            html+="<tr>";
            html+="<td>"+e.getId()+"</td>";
            html+="<td>"+e.getName()+"</td>";
            html+="<td>"+e.getAge()+"</td>";
            html+="<td>"+e.getJob()+"</td>";
            html += "<td><a href='/delete_emp?id="+e.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html+="</table>";

        return html;
    }

    @RequestMapping("/delete_emp")
    @ResponseBody
    public String delete_emp(int id){
        try (
                Connection connection = DBUtil.getConnection();
        ){
            String sql = "delete from myemp where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html="<a href='/'>返回首页</a>";
        return "删除成功"+html;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update_emp(int id ,String name,int age,String job){
        try (
                Connection connection = DBUtil.getConnection();
        ){
            String sql = "update myemp set name=?,age=?,job=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setString(3,job);
            ps.setInt(4,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html="<a href='/'>返回首页</a>";
        return "修改成功"+html;
    }

}
