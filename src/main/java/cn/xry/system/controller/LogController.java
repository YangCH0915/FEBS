package cn.xry.system.controller;

import cn.xry.common.controller.BaseController;
import cn.xry.common.domain.QueryRequest;
import cn.xry.common.domain.ResponseBo;
import cn.xry.common.util.FileUtils;
import cn.xry.system.domain.SysLog;
import cn.xry.system.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class LogController extends BaseController {

	@Autowired
	private LogService logService;

	@RequestMapping("log")
	@RequiresPermissions("log:list")
	public String index() {
		return "system/log/log";
	}

	@RequestMapping("log/list")
	@ResponseBody
	public Map<String, Object> logList(QueryRequest request, SysLog log) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<SysLog> list = this.logService.findAllLogs(log);
		PageInfo<SysLog> pageInfo = new PageInfo<>(list);
		return getDataTable(pageInfo);
	}

	@RequestMapping("log/excel")
	@ResponseBody
	public ResponseBo logExcel(SysLog log) {
		try {
			List<SysLog> list = this.logService.findAllLogs(log);
			return FileUtils.createExcelByPOIKit("系统日志表", list, SysLog.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("导出Excel失败，请联系网站管理员！");
		}
	}

	@RequestMapping("log/csv")
	@ResponseBody
	public ResponseBo logCsv(SysLog log){
		try {
			List<SysLog> list = this.logService.findAllLogs(log);
			return FileUtils.createCsv("系统日志表", list, SysLog.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("导出Csv失败，请联系网站管理员！");
		}
	}
	
	@RequiresPermissions("log:delete")
	@RequestMapping("log/delete")
	@ResponseBody
	public ResponseBo deleteLogss(String ids) {
		try {
			this.logService.deleteLogs(ids);
			return ResponseBo.ok("删除日志成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("删除日志失败，请联系网站管理员！");
		}
	}
}
