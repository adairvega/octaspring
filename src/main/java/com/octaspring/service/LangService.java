package com.octaspring.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.octaspring.dao.LangInterface;
import com.octaspring.entity.Lang;

public class LangService implements LangInterface {
   private JdbcTemplate jdbcTemplate;
   String sql;
   
   public LangService(DataSource dataSource) {
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }

   @Override
   public void save(Lang lang) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void update(Lang lang) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void delete(Lang lang) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public List<Lang> findByAll() {
      //System.out.println("Find by all");
      
      sql = "SELECT * FROM lang";
      return this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Lang.class));
   }

   @Override
   public List<Lang> findById() {
      // TODO Auto-generated method stub
      return null;
   }
}
