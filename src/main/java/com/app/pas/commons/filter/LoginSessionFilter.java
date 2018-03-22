package com.app.pas.commons.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.pas.dto.MemberVo;

public class LoginSessionFilter implements Filter {

   /* private FilterConfig filterConfig; */
   private List<String> whiteList;
   private List<String> staticResourceList;
   private static int PROJNUM=1;

   public LoginSessionFilter() {
      whiteList = new ArrayList<String>();
      whiteList.add("/index");
      whiteList.add("/main/loginForm");

      staticResourceList = new ArrayList<String>();
      staticResourceList.add("/resource/");
   }

   @Override
   public void init(FilterConfig filterconfig) throws ServletException {

   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
         FilterChain chain) throws IOException, ServletException {

      HttpServletRequest req = (HttpServletRequest) request;
      HttpServletResponse res = (HttpServletResponse) response;
      HttpSession session = req.getSession();

      String uri = req.getRequestURI();
      /*
       * if(!whiteList.contains(uri)){ boolean isURIResourceFile=false;
       * 
       * 
       * for(String staticResource:staticResourceList){
       * if(uri.startsWith(staticResource)){ isURIResourceFile=true; break;
       * 
       * } }
       * 
       * if(!isURIResourceFile){ HttpSession session = req.getSession();
       * 
       * MemberVo member =(MemberVo)session.getAttribute("loginUser");
       * if(member ==null){ HttpServletResponse res = (HttpServletResponse)
       * response; res.sendRedirect("/index"); return; } }
       * 
       * }
       */

     

      int proj_Num = 1;
      int proj_NumN = 1;

      MemberVo member = (MemberVo) session.getAttribute("loginUser");

      if (request.getParameter("proj_Num") == null) {
            
      } else {
         proj_NumN = Integer.parseInt(request.getParameter("proj_Num"));
         PROJNUM=proj_NumN; 

      }

      if (session.getAttribute("joinProj") == null) {
            proj_Num=proj_NumN;
      } else {
         proj_Num = Integer.parseInt((String) session
               .getAttribute("joinProj"));
      }
      

      if (member == null || proj_Num != PROJNUM) {
         res.sendRedirect("/index");
         return;
      } else {
         
      }

      chain.doFilter(req, res);
   }

   @Override
   public void destroy() {

   }

}