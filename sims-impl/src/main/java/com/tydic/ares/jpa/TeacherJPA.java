package com.tydic.ares.jpa;

import com.tydic.ares.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author Ares
 * @date 2018/7/26 19:04
 * @description:
 * @version JDK 1.8
 */
public interface TeacherJPA extends JpaRepository<Teacher,Long>,JpaSpecificationExecutor<Teacher>,Serializable
{
}
