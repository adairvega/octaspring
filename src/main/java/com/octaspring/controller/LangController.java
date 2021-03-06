package com.octaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.octaspring.dao.LangInterface;
import com.octaspring.entity.Lang;

@Controller
public class LangController {

   @Autowired
   private LangInterface langInterface;
   
   @GetMapping("/lang")
   public String lang(Model model) {
      List<Lang> listaCTRL = langInterface.findByAll();
      model.addAttribute("listaTL", listaCTRL);
      model.addAttribute("name", "Adair");
      return "admin/lang";
   }
}
