package com.example.demo.mybatis.demo;

import com.example.demo.mapper.TestMapper;
import com.example.demo.mybatis.beans.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: maofujiang
 * Date: 2018/9/29
 */
public class MyBatisDemo {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() throws FileNotFoundException {
        InputStream configFile = new FileInputStream("");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        return sqlSessionFactory.openSession();
    }

    public static SqlSessionFactory getSqlSessionFactory() throws FileNotFoundException {
        InputStream configFile = new FileInputStream("");
        if (null != sqlSessionFactory) {
            return sqlSessionFactory;
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        return sqlSessionFactory;
    }

    public static Test getOne(SqlSession sqlSession, int id) throws SQLException {
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        long startTime = System.currentTimeMillis();
        Test test = testMapper.selectByPrimaryKey(id);
        long endTime = System.currentTimeMillis();
        System.out.println("getOne spendTime[" + (endTime - startTime) + "ms]");
        return test;
    }
}
