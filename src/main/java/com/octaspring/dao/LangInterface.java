package com.octaspring.dao;

import java.util.List;

import com.octaspring.entity.Lang;

public interface LangInterface {
   public void save(Lang lang);
   
   public void update(Lang lang);
   
   public void delete(Lang lang);
   
   public List<Lang> findByAll();
   
   public List<Lang> findById();
}
