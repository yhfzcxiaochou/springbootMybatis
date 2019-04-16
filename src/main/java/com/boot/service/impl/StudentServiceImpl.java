package com.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.StudentMapper;
import com.boot.entity.Student;
import com.boot.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private RedisTemplate<Object, Object> redisTemp;
	@Override
	public List<Student> getAllStudent() {
		//字符串的序列化器
		RedisSerializer redisser=new StringRedisSerializer();
		redisTemp.setKeySerializer(redisser);
		//查询缓存 
		List<Student> stuList=(List<Student>) redisTemp.opsForValue().get("allStudent");
		if(null==stuList){
			//缓存为空，查询数据库
			stuList=studentMapper.selectAllStudent();
			//将数据放入缓存
			redisTemp.opsForValue().set("allStudent", stuList);
		}
		return stuList;
	}
	@Transactional
	@Override
	public int update(Student stu) {
	
		int update=studentMapper.updateByPrimary(stu);
		System.out.println("更新结果"+update);
//		int i=1/0;
		return update;
	}

}
