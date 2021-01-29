package com.util;
import java.io.File;
/*
 * 공통코드 체험하기
 * 사용자로 부터 입력 받는 값을 효과적으로 처리해 본다.
 * API보는 방법과 활용능력을 키워본다.
 */
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HashMapBinder {
   Logger logger = Logger.getLogger(HashMapBinder.class);
   //post방식으로 첨부 파일을 처리할 때 request대신 사용할 객체 - 
   //이것이 있어야 사용자가 입력한 값을 받을 수 있다.
   MultipartRequest multi = null;
   //첨부파일 한글처리
   String encType = "utf-8";
   //첨부파일의 크기
   int maxSize = 10*1024*1024;//10MB
   //첨부파일의 물리적인 위치
   String realFolder = "";
   public HttpServletRequest request = null;
   public HashMapBinder() {
      
   }
   public HashMapBinder(HttpServletRequest request) {
      this.request = request;
      realFolder = "C:\\workspace_sts3\\spring3_1\\src\\main\\webapp\\pds";
   }
   public void multiBind(Map<String,Object> target) {
      target.clear();
      try {
         multi = new MultipartRequest(request, realFolder, maxSize, encType
                                  , new DefaultFileRenamePolicy());
      } catch (Exception e) {
         logger.info("Exception:"+e.toString());
      }
      logger.info("multi: "+multi);
      Enumeration<String> en = multi.getParameterNames();
      while(en.hasMoreElements()) {
         String key = en.nextElement();
         target.put(key, multi.getParameter(key));
      }
      //첨부 파일에 대한 정보를 받아오는 코드 추가
      Enumeration<String> files = multi.getFileNames();
      if(files !=null) {
         //읽어온 파일 이름을 객체로 만들어 준다.
         File file = null;
         while(files.hasMoreElements()) {
            String fname = files.nextElement();
            String filename = multi.getFilesystemName(fname);
            logger.info("filname : "+filename);
            //사용자가 선택한 파일명 담기-널이아니면 첨부파일 있다.
            target.put("bs_file",filename);
            //파일 크기를 계산하려면 파일명으로 파일 객체를 생성해야 length함수를 사용 가능함.
            if(filename !=null && filename.length()>1) {
               file = new File(realFolder +"\\" + filename);
            }
         }/////////////end while
         //첨부파일의 크기를 담기
         double size = 0;
         if(file !=null) {
            size = file.length();
            size = size/1024;//kb
            target.put("bs_size",size);
         }
      }
   }
   /******************************************************************************************
    * 첨부파일이 없는 경우
    * @param target
    *****************************************************************************************/
   public void bind(Map<String,Object> target) {
      target.clear();
      Enumeration<String> en = request.getParameterNames();
      while(en.hasMoreElements()) {
         //<input name="mem_id"
         String key = en.nextElement();//mem_id, mem_pw, mem_addr, mem_hp
         target.put(key, HangulConversion.toUTF(request.getParameter(key)));
         logger.info(key+" , "+target.get(key));
      }
   }
}








