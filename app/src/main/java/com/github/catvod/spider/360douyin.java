import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//public String detailContent(List<String> ids)函数内，return result之前处理播放列表
String[] fromArray = list.getString("vod_play_from").split("\\$\\$\\$");

// 检查数组长度是否不等于1
if (fromArray.length != 1) {
    // 查找"douyin"所在的索引并删除
    List<String> fromList = new ArrayList<>(Arrays.asList(fromArray));
    int douyinIndex = fromList.indexOf("douyin");
    if (douyinIndex != -1) {
        fromList.remove(douyinIndex);
    }
    // 更新vod_play_from的值
    list.put("vod_play_from", String.join("$$$", fromList));
    
    // 分割vod_play_url的值成数组
    String[] urlArray = list.getString("vod_play_url").split("\\$\\$\\$");
    // 删除相同索引的值
    List<String> urlList = new ArrayList<>(Arrays.asList(urlArray));
    if (douyinIndex != -1 && douyinIndex < urlList.size()) {
        urlList.remove(douyinIndex);
    }
    // 更新vod_play_url的值
    list.put("vod_play_url", String.join("$$$", urlList));
}