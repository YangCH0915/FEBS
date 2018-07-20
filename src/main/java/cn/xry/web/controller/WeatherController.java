package cn.xry.web.controller;

import cn.xry.common.annotation.Log;
import cn.xry.common.controller.BaseController;
import cn.xry.common.domain.ResponseBo;
import cn.xry.common.util.HttpUtils;
import cn.xry.common.util.UrlUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController extends BaseController {

	@Log("获取天气信息")
	@RequestMapping("weather")
	@RequiresPermissions("weather:list")
	public String weather() {
		return "web/weather/weather";
	}

	@RequestMapping("weather/query")
	@ResponseBody
	public ResponseBo queryWeather(String areaId) {
		try {
			String data = HttpUtils.sendPost(UrlUtils.MEIZU_WEATHER_URL, "cityIds=" + areaId);
			return ResponseBo.ok(data);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("查询天气失败，请联系网站管理员！");
		}
	}
}
