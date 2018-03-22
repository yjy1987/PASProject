package com.app.pas.service.dic;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.LinkedMap;

import com.app.pas.dao.dic.GantChartDao;
import com.app.pas.dto.dic.GantChartCommand;
import com.app.pas.dto.dic.GantChartVo;

public class GantChartService {

	private GantChartDao gantChartDao;

	public void setGantChartDao(GantChartDao gantChartDao) {
		this.gantChartDao = gantChartDao;
	}
	public List<GantChartVo> selectGantChart(int proj_Num) throws SQLException{
		List<GantChartVo> list= gantChartDao.selectGantChart(proj_Num);
		return list;
	}
	
	public boolean updateGantChart(List<LinkedHashMap<String,Object>> list,int proj_Num) throws SQLException, ParseException{
		gantChartDao.deleteGantChart(proj_Num);
		int result = 0;
		boolean flag=false;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM",Locale.KOREA);
		for(Map<String, Object> x : list){
			GantChartCommand gantChartCommand = new GantChartCommand();
			GantChartVo gantChartVo = new GantChartVo();
			
			gantChartCommand.setId(x.get("id")+"");
			gantChartCommand.setStart(sdf.parse(((String) x.get("start")).replace("T", " ")));
			gantChartCommand.setEnd(sdf.parse(((String) x.get("end")).replace("T", " ")));
			gantChartCommand.setTitle((String) x.get("title"));
			gantChartCommand.setParentId((String) x.get("parentId"));
			
			
			if(x.get("percentComplete").equals(0)){
				gantChartCommand.setPercentComplete(0.0);
			}else{
				gantChartCommand.setPercentComplete( (Double) x.get("percentComplete"));
			}
			
			GantChartVo vo = gantChartVo.fromCommand(gantChartCommand);
			vo.setProj_Num(proj_Num);
			gantChartDao.insertGantChart(vo);
		}
		
		if(result>0){ flag = true; }
		
		return flag;
	}
}
